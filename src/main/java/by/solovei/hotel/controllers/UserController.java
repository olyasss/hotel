package by.solovei.hotel.controllers;

import by.solovei.hotel.models.User;
import by.solovei.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;

    //show all users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.listUser());
        return "usersList";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getFormUsers(Model model){
        model.addAttribute("userFromForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userFromForm") User user,
                          @ModelAttribute("user_session") User userSession){
        userService.addUser(user);
        userSession=user;
        return "redirect:/home";
    }

}
