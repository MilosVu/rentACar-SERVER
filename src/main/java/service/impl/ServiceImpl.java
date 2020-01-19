package service.impl;

import config.ApplicationConfiguration;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import service.CarService;



@Service
public class ServiceImpl implements service.Service {

    @Override
    public String answerGenerator(User user, String command, Object parameters) {
        return null;
    }
}
