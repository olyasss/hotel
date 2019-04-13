package by.solovei.hotel.controllers;

import by.solovei.hotel.models.Booking;
import by.solovei.hotel.models.Room;
import by.solovei.hotel.models.User;
import by.solovei.hotel.services.BookingService;
import by.solovei.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@SessionAttributes("user_session")
@RequestMapping("/")
public class BookingController {

    public Date date11;
    public Date date22;
    public List<Room> rooms = new ArrayList<>();

    @Autowired
    public BookingService bookingService;

    @Autowired
    public RoomService roomService;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @ModelAttribute("freeRoomsList")
    public List<Room> populateFreeRoomsList(){
        return new ArrayList<>();
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String getAllBookings(Model model, @ModelAttribute("user_session") User user){

        try {
            if (user.getLogin().equals("admin")) {
                model.addAttribute("book", bookingService.listBooking());
                return "bookingsList";
            } else {
                model.addAttribute("info", "sorry, only admin can see this data!");
                return "redirect:/endPage";
            }
        } catch (Exception e){
            model.addAttribute("info", "sorry, only admin can see this data!");
            return "redirect:/endPage";
        }
    }

    @RequestMapping(value = "/booking/delete", method = RequestMethod.POST)
    public String getAllBookings(Model model, @RequestParam("bookingId") Integer bookingId) {
        try {
            bookingService.deleteBooking(bookingId);
            model.addAttribute("info", "booking " + bookingId + " is deleted!");
            return "redirect:/endPage";
        } catch (Exception e){
            model.addAttribute("info", "please, enter correct data!");
            return "redirect:/endPage";
        }
    }

    @RequestMapping(value = "/bookingroom", method = RequestMethod.GET)
    public String bookingRoom(@ModelAttribute("user_session") User user,
                              @ModelAttribute("freeRoomsList") List freeRoomsList){
        if(rooms.size()!=0){
            freeRoomsList.addAll(rooms);
        }
        return "booking";
    }

    //Selecting free rooms for entered dates
    @RequestMapping(value = "/bookingroom/date", method = RequestMethod.POST)
    public String selectFreeRooms(@ModelAttribute("dateFrom") Date date1,
                                  @ModelAttribute("dateTo") Date date2,
                                  Model model){
        rooms.clear();
        rooms.addAll(bookingService.freeRooms(date1, date2, roomService.listRoom()));

        date11 = date1;
        date22 = date2;


        if(date1 == null){
        model.addAttribute("message", "null");} else {
            model.addAttribute("message", date1);
        }
        return "redirect:/bookingroom";
    }


    //booking room
    @RequestMapping(value = "/bookingroom/book", method = RequestMethod.POST)
    public String bookingProcess(@RequestParam("roomNumber") Integer num,
                                 @ModelAttribute("user_session") User user,
                                 @RequestParam("passport") String passport,
                                 Model model){

        if(user.getLogin() == null){
            model.addAttribute("info", "please, log in for booking room!");
            return "redirect:/endPage";
        }
        try {
            Booking booking = new Booking(user, roomService.getRoomByNumber(num),
                    date11, date22, passport);
            bookingService.addBooking(booking);

            model.addAttribute("info", "you have booked room " + num);

            return "redirect:/endPage";
        } catch (Exception e){
            model.addAttribute("info", "please, enter correct data!");
            return "redirect:/endPage";
        }
    }

    @RequestMapping(value = "/endPage", method = RequestMethod.GET)
    public String notFound(@ModelAttribute("info") String info){
        return "endPage";
    }



}
