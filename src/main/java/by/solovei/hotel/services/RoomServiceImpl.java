package by.solovei.hotel.services;

import by.solovei.hotel.dao.RoomDAO;
import by.solovei.hotel.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomDAO roomDAO;

    public void setRoomDAO(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    @Transactional
    public void addRoom(Room room) {
        this.roomDAO.addRoom(room);
    }

    @Override
    @Transactional
    public void updateRoom(Room room) {
        this.roomDAO.updateRoom(room);
    }

    @Override
    @Transactional
    public List<Room> listRoom() {
        return this.roomDAO.listRoom();
    }

    @Override
    @Transactional
    public Room getRoomById(int id) {
        return this.roomDAO.getRoomById(id);
    }

    @Override
    @Transactional
    public void deleteRoom(int id) {
        this.roomDAO.deleteRoom(id);
    }
}
