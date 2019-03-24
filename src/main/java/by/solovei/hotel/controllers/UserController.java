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
        model.addAttribute("userFromForm", new User());
        return "usersList";
    }

    //add user
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userFromForm") User user){
        userService.addUser(user);
        return "redirect:/users";
    }

}
