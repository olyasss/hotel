package by.solovei.hotel.dao;

import by.solovei.hotel.models.Room;

import java.util.List;

public interface RoomDAO {

    void addRoom(Room room);
    void updateRoom(Room room);
    List<Room> listRoom();
    Room getRoomById(int id);
    Room getRoomByNumber(int number);
    void deleteRoom(int id);

}
