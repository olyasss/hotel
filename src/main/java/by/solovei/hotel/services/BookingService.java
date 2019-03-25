package by.solovei.hotel.services;

import by.solovei.hotel.models.Booking;
import by.solovei.hotel.models.Room;

import java.util.Date;
import java.util.List;

public interface BookingService {

    public void addBooking(Booking booking);
    public void updateBooking(Booking booking);
    public List<Booking> listBooking();
    public Booking getBookingById(int id);
    public void deleteBooking(int id);
    public List<Booking> bookedRooms(Date from, Date to);
    public List<Room> freeRooms(Date from, Date to, List<Room> listRoom);

}
