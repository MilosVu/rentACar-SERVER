package service.impl;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.net.Socket;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User logIn(String username, String password) {
        return userRepository.logIn(username,password);
    }

    public boolean register(User user) {
        return userRepository.register(user);
    }

    @Override
    public String doesExist(User user) {
        return userRepository.doesExist(user);
    }


}
