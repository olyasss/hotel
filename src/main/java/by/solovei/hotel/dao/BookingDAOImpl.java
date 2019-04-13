package by.solovei.hotel.dao;

import by.solovei.hotel.models.Booking;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBooking(Booking booking) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(booking);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> listBooking() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Booking> bookingsList = session.createQuery("from Booking").list();
        return bookingsList;
    }

    @Override
    public Booking getBookingById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Booking booking = (Booking) session.load(Booking.class, new Integer(id));
        return booking;
    }

    @Override
    public void deleteBooking(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Booking booking = (Booking) session.load(Booking.class, new Integer(id));
        if(booking != null){
            session.delete(booking);
        }
    }

    @Override
    public List<Booking> bookedRooms(Date from, Date to) {
        Session session = this.sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(Booking.class);
        Criterion crit1 = Restrictions.and(Restrictions.lt("dateFrom",from),
                (Restrictions.gt("dateTo",from)));

        Criterion crit2 = Restrictions.between("dateFrom", from,to);

        criteria.add(Restrictions.or(crit1,crit2));

        if(criteria.list().size()!=0) {
            return criteria.list();
        } else {
            return null;
        }
    }
}
