package by.solovei.hotel.dao;

import by.solovei.hotel.models.User;

import java.util.List;

public interface UserDao {

    public void addUser(User u);
    public void updateUser(User u);
    public List<User> listUser();
    public User getUserById(int id);
    public void removeUser(int id);
    public User getUserByLogin(String login);
}
