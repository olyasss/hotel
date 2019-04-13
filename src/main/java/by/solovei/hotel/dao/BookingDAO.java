package by.solovei.hotel.dao;

import by.solovei.hotel.models.Booking;

import java.util.Date;
import java.util.List;

public interface BookingDAO {

    void addBooking(Booking booking);
    void updateBooking(Booking booking);
    List<Booking> listBooking();
    Booking getBookingById(int id);
    void deleteBooking(int id);
    List<Booking> bookedRooms(Date from, Date to);
}
