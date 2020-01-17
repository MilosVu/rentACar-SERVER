package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    public static LinkedList<ServerThreads> clients = new LinkedList<>();
    public static void main(String[] args){

        try {
            ServerSocket serverSocket = new ServerSocket(14000);

            Socket socketForCommunication = null;
            while(true) {
                System.out.println("Waiting...");
                socketForCommunication = serverSocket.accept();
                System.out.println("Connection accepted...");
                ServerThreads newClient = new ServerThreads(socketForCommunication);
                clients.add(newClient);

                newClient.start();
            }

        } catch (IOException e) {
            System.out.println("Error while starting server... " + e.getMessage());
        }

    }

}
