package by.solovei.hotel.dao;

import by.solovei.hotel.models.User;

import java.util.List;

public interface UserDao {

    void addUser(User u);
    void updateUser(User u);
    List<User> listUser();
    User getUserById(int id);
    void removeUser(int id);
    User getUserByLogin(String login);
}
