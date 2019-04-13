package by.solovei.hotel.controllers;

import by.solovei.hotel.models.User;
import by.solovei.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("user_session")
@RequestMapping("/")
public class HomeController  {

    @Autowired
    public UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @ModelAttribute("user_session")
    public User populateUser(){
        return  new User();
    }

   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sessionAttributes () {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homeForm(Model model) {
        model.addAttribute("log", new User());
        return "home";
    }

    //log in
    @RequestMapping(value = "/home/dologin", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("user_session") User userSession,
                          @ModelAttribute("log") User userLog,
                          Model model){
        User user = userService.getUserByLogin(userLog.getLogin());
        if(user != null){
            if(user.getPassword().equals(userLog.getPassword())){
                userSession.setParams(user);
                return "redirect:/home";
            }
            else {
                model.addAttribute("info", "please, enter correct password!");
                return "redirect:/endPage";
            }
        }
        else {
            model.addAttribute("info", "please, enter correct login!");
            return "redirect:/endPage";
        }
    }

}
