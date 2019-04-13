package by.solovei.hotel.services;

import by.solovei.hotel.models.Room;

import java.util.List;

public interface RoomService {

    void addRoom(Room room);
    void updateRoom(Room room);
    List<Room> listRoom();
    Room getRoomById(int id);
    void deleteRoom(int id);
    Room getRoomByNumber(int number);
}

