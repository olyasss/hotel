package by.solovei.hotel.services;

import by.solovei.hotel.models.User;

import java.util.List;

public interface UserService {

    public void addUser(User u);
    public void updateUser(User u);
    public List<User> listUser();
    public User getUserById(int id);
    public void removeUser(int id);

}
