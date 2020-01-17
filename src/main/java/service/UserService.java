package service;

import domain.User;

import java.net.Socket;

public interface UserService {

    User logIn(String username, String password);

    boolean register(User user);

    String doesExist(User user);

}
