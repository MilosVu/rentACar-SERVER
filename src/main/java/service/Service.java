package service;

import domain.User;

import java.net.Socket;

public interface Service {

    String answerGenerator(User user, String command, Object parameter);

}
