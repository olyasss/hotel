package by.solovei.hotel.controllers;

import by.solovei.hotel.models.User;
import by.solovei.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user_session")
public class UserController {

    @Autowired
    public UserService userService;

    //show all users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model, @ModelAttribute("user_session") User user){

        try {
            if (user.getLogin().equals("admin")) {
                model.addAttribute("users", userService.listUser());
                return "userList";
            } else {
                model.addAttribute("info", "sorry, only admin can see this data!");
                return "redirect:/endPage";
            }
        } catch (Exception e){
            model.addAttribute("info", "sorry, only admin can see this data!");
            return "redirect:/endPage";
        }
    }

    //delete user
    @RequestMapping(value = "/users/delete", method = RequestMethod.POST)
    public String getAllUsers(Model model, @RequestParam("userId") Integer userId){
        try {
            userService.removeUser(userId);
            model.addAttribute("info", "user " + userId + " is deleted!");
            return "redirect:/endPage";
        } catch (Exception e){
            model.addAttribute("info", "please, enter correct data!");
            return "redirect:/endPage";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getFormUsers(Model model, @ModelAttribute("user_session") User user){
        model.addAttribute("userFromForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userFromForm") User user,
                          @ModelAttribute("user_session") User userSession,
                          Model model){
        try {
            userService.addUser(user);
            userSession.setParams(user);
            return "redirect:/home";
        } catch (Exception e){
            model.addAttribute("info", "please, enter correct data!");
            return "endPage";
        }
    }

}
