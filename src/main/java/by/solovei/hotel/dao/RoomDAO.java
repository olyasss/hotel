package by.solovei.hotel.dao;

import by.solovei.hotel.models.Room;

import java.util.List;

public interface RoomDAO {

    public void addRoom(Room room);
    public void updateRoom(Room room);
    public List<Room> listRoom();
    public Room getRoomById(int id);
    public void deleteRoom(int id);

}
