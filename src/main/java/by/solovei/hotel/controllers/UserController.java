package by.solovei.hotel.controllers;

import by.solovei.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model){

        model.addAttribute("users", userService.listUser());
        return "usersList";
    }
}
