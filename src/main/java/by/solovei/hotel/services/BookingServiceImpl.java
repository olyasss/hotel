package by.solovei.hotel.services;

import by.solovei.hotel.dao.BookingDAO;
import by.solovei.hotel.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
