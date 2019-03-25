package by.solovei.hotel.dao;

import by.solovei.hotel.models.Room;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addRoom(Room room) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(room);
    }

    @Override
    public void updateRoom(Room room) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(room);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> listRoom() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Room> roomList = session.createQuery("from Room").list();
        return roomList;
    }

    @Override
    public Room getRoomById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Room room = (Room) session.load(Room.class, new Integer(id));
        return room;
    }

    @Override
    public Room getRoomByNumber(int number) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Room.class);
        criteria.add(Restrictions.eq("number", number));
        Room room = (Room) criteria.uniqueResult();
        return room;
    }

    @Override
    public void deleteRoom(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Room room = (Room) session.load(Room.class, new Integer(id));
        if(room != null){
            session.delete(room);
        }
    }
}
