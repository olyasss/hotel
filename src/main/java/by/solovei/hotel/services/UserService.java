package by.solovei.hotel.services;

import by.solovei.hotel.models.User;

import java.util.List;

public interface UserService {

    void addUser(User u);
    void updateUser(User u);
    List<User> listUser();
    User getUserById(int id);
    void removeUser(int id);
    User getUserByLogin(String login);
}
