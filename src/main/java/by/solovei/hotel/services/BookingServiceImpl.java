package by.solovei.hotel.services;

import by.solovei.hotel.dao.BookingDAO;
import by.solovei.hotel.models.Booking;
import by.solovei.hotel.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDAO bookingDAO;


    public void setBookingDAO(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    @Transactional
    public void addBooking(Booking booking) {
        this.bookingDAO.addBooking(booking);
    }

    @Override
    @Transactional
    public void updateBooking(Booking booking) {
        this.bookingDAO.updateBooking(booking);
    }

    @Override
    @Transactional
    public List<Booking> listBooking() {
        return this.bookingDAO.listBooking();
    }

    @Override
    @Transactional
    public Booking getBookingById(int id) {
        return this.bookingDAO.getBookingById(id);
    }

    @Override
    @Transactional
    public void deleteBooking(int id) {
        this.bookingDAO.deleteBooking(id);
    }

    @Override
    @Transactional
    public List<Booking> bookedRooms(Date from, Date to) {
        return this.bookingDAO.bookedRooms(from, to);
    }

    @Transactional
    public List<Room> freeRooms(Date from, Date to, List<Room> listRooms){
/*
        List<Booking> listBooking = this.bookingDAO.bookedRooms(from, to);
        if(listBooking == null) {
            return listRooms;
        } else {
            Predicate<Room> predicate = new Predicate<Room>() {
                @Override
                public boolean test(Room room) {
                    for (Booking booking : listBooking) {
                        if (room.getId() == booking.getRoom().getId()) {
                            return true;
                        }
                    }
                    return false;
                }
            };
            listRooms.removeIf(predicate);
            return listRooms;
        }*/
        return listRooms;
    }
}
