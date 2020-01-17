package test;

import config.ApplicationConfiguration;
import domain.Reservation;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.UserRepository;
import repository.impl.ReservationRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.CarService;
import service.ReservationService;
import service.Service;
import service.UserService;
import service.impl.ReservationServiceImpl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//        UserService userService = context.getBean(UserService.class);
//        ReservationService reservationService = context.getBean(ReservationService.class);
//        Service service = context.getBean(Service.class);
        CarService carService = context.getBean(CarService.class);
        carService.advertisedCars();
        carService.preview();
//        String[][] brandAndModel = {{"BMW",null},{"Nissan","Micra"}};
//        System.out.println("*****************");
//        carService.preview();
//        User user = new User("MilosVu1231","milosvu","Milos","Vujic","vujic.milos@gmail.com");
//        userService.register(user);

//        Reservation resevation = new Reservation("MilosVu",1,new Date(2020-1900,1,1),new Date(2020-1900,2,1),300,null);
//        if(reservationService.changeDate(4,new Date(2021-1900,6,6),new Date(2021-1900,6,6))){
//            System.out.println("Otkazano");
//        }
//        else
//            System.out.println("Jok");
//        Date datum = new Date(2020 - 1900,11,12);
//        System.out.println(datum);



//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File("strawberry.jpg"));
//        } catch (IOException e) {
//        }
    }

}
