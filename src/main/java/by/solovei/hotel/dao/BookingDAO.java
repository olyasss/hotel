package by.solovei.hotel.dao;

import by.solovei.hotel.models.Booking;

import java.util.List;

public interface BookingDAO {

    public void addBooking(Booking booking);
    public void updateBooking(Booking booking);
    public List<Booking> listBooking();
    public Booking getBookingById(int id);
    public void deleteBooking(int id);
}
