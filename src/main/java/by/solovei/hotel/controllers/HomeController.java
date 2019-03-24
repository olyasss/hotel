package by.solovei.hotel.controllers;

import by.solovei.hotel.models.User;
import by.solovei.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController  {
    @Autowired
    public UserService userService;

    @ModelAttribute("user_session")
    public User populateUser(){
        return  new User();
    }

    //log in
    @RequestMapping(value = "/home/dologin", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("user_session") User userSession, @ModelAttribute("log") User userLog){
        User user = userService.getUserByLogin(userLog.getLogin());
        if(user != null){
            if(user.getPassword().equals(userLog.getPassword())){
                userSession = user;

                return "redirect:/home";
            }
            else return "notFound";
        }
        else return "notFound";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homeForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("log", new User());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/homeAttr";
    }
}
