package by.solovei.hotel.services;

import by.solovei.hotel.models.Booking;
import by.solovei.hotel.models.Room;

import java.util.Date;
import java.util.List;

public interface BookingService {

    void addBooking(Booking booking);
    void updateBooking(Booking booking);
    List<Booking> listBooking();
    Booking getBookingById(int id);
    void deleteBooking(int id);
    List<Booking> bookedRooms(Date from, Date to);
    List<Room> freeRooms(Date from, Date to, List<Room> listRoom);

}
