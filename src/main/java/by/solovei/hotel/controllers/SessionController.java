package by.solovei.hotel.controllers;

import by.solovei.hotel.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("user_session")
public class SessionController {

    @RequestMapping(value = "/homeAttr", method = RequestMethod.GET)
    public String sessionAttributes (@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject(user);
        return "redirect:/home";
    }
}
