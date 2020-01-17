package repository;

import domain.User;

public interface UserRepository {

    public User logIn(String username, String password);

    public boolean register(User user);

    String doesExist(User user);
}
