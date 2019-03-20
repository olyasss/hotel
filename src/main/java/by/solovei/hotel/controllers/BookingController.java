package by.solovei.hotel.controllers;

import by.solovei.hotel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String getAllBookings(Model model){
        model.addAttribute("book", bookingService.listBooking());
        return "bookingsList";
    }


}
