package by.solovei.hotel.controllers;

import by.solovei.hotel.models.Booking;
import by.solovei.hotel.models.DateInfo;
import by.solovei.hotel.models.Room;
import by.solovei.hotel.models.User;
import by.solovei.hotel.services.BookingService;
import by.solovei.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @Autowired
    public RoomService roomService;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String getAllBookings(Model model){
        model.addAttribute("book", bookingService.listBooking());
        return "bookingsList";
    }

    @RequestMapping(value = "/bookingroom", method = RequestMethod.GET)
    public ModelAndView bookingRoom(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dateForm", new DateInfo());
        modelAndView.addObject("roomNumber",new Integer(1));
        modelAndView.setViewName("booking");
        return modelAndView;

    }

    @RequestMapping(value = "/bookingroom/date", method = RequestMethod.POST)
    public String selectFreeRooms(@ModelAttribute("dateForm") DateInfo dateInfo, Model model){
        model.addAttribute("freeRoomsList", bookingService.freeRooms(dateInfo.getDateFrom(),
                dateInfo.getDateTo(), roomService.listRoom()));
        return "booking";
    }

    @RequestMapping(value = "/bookingroom/book", method = RequestMethod.POST)
    public String bookingProcess(@ModelAttribute("roomNumber") Integer num,
                                 @ModelAttribute("user_session") User user,
                                 @ModelAttribute("dateInfo")DateInfo dateInfo){

        Booking booking = new Booking(user,roomService.getRoomByNumber(num),
                dateInfo.getDateFrom(),dateInfo.getDateTo());
        bookingService.addBooking(booking);
        return "redirect:/bookingroom";
    }

}
