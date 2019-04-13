package by.solovei.hotel.controllers;

import by.solovei.hotel.models.Room;
import by.solovei.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("user_session")
public class RoomController {

    @Autowired
    public RoomService roomService;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public String getAllRooms(Model model){
        model.addAttribute("rooms", roomService.listRoom());
        return "roomsList";
    }

}
