package server;

import config.ApplicationConfiguration;
import domain.Reservation;
import domain.Search;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CarService;
import service.ReservationService;
import service.Service;
import service.UserService;

import java.io.*;
import java.net.Socket;

public class ServerThreads extends Thread{
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    UserService userService = context.getBean(UserService.class);
    Service service = context.getBean(Service.class);
    CarService carService = context.getBean(CarService.class);
    ReservationService reservationService = context.getBean(ReservationService.class);

    Socket socketForCommunication = null;
    public static InputStream inputStream = null;
    public static OutputStream outputStream = null;
    public static BufferedReader streamFromClient = null;
    public static PrintStream streamToClient = null;
    public static ObjectInputStream objectInputStream = null;
    public static ObjectOutputStream objectOutputStream = null;
    String command = null;
    String parameters = null;
    String[] textArray = new String[3];
    String username = null;
    String password = null;
    String status = null;
    boolean log = false;
    User user = null;
    String response;
    private Search search;

    public ServerThreads(Socket socketForCommunication) {
        this.socketForCommunication = socketForCommunication;
    }

    public void run() {
        try {
            inputStream = socketForCommunication.getInputStream();
            outputStream = socketForCommunication.getOutputStream();
            streamFromClient = new BufferedReader(new InputStreamReader(inputStream));
            streamToClient = new PrintStream(outputStream);

            objectInputStream = new ObjectInputStream(socketForCommunication.getInputStream());
            objectOutputStream = new ObjectOutputStream(socketForCommunication.getOutputStream());

            System.out.println("Connected");

            while(!log) {
                User user = (User) objectInputStream.readObject();
                System.out.println(user);
                command = streamFromClient.readLine();
                System.out.println(command);
                if(command.equals("logIn")) {
                    System.out.println("Log in ");
                     user = userService.logIn(user.getUsername(), user.getPassword());
                    if(user != null) {
                        streamToClient.println("You have signed in");
                        log = true;
                   }
                    else {
                        streamToClient.println("Wrong username or password");
                    }
                }

                else {
                    response = userService.doesExist(user);
                    if(response.equals("OK")){
                        if(userService.register(user))
                            streamToClient.println("You have registered successfully");
                        else
                            streamToClient.println("Username already taken");
                    }
                    else
                        streamToClient.println(response);
                }
            }

            while(true) {
                command = streamFromClient.readLine();
                switch (command){
                    case "advertisedCars":
                        carService.advertisedCars();
                        break;
                    case "search":
                        search = (Search) objectInputStream.readObject();
                        carService.search(search);
                        break;
                    case "reserve":
                        reservationService.reserve((Reservation) objectInputStream.readObject());
                        break;
                        default:
                            System.out.println("ERROR");
                            break;
                }
            }

        } catch (Exception e) {
            System.out.println("User left");
            System.out.println(e.getStackTrace());
            System.out.println("\n\n" + e.getMessage());
        }
    }

}
