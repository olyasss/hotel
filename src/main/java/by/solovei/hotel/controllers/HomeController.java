package by.solovei.hotel.controllers;

import by.solovei.hotel.models.DateInfo;
import by.solovei.hotel.models.User;
import by.solovei.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
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

    //log in
    @RequestMapping(value = "/home/dologin", method = RequestMethod.POST)
    public String doLogin(Model model, @ModelAttribute("user_session") User userSession,
                          @ModelAttribute("log") User userLog){
        User user = userService.getUserByLogin(userLog.getLogin());
        if(user != null){
            if(user.getPassword().equals(userLog.getPassword())){
                userSession=user;
                String str = userSession.getLogin();
                model.addAttribute("message", str);
                return "redirect:/home";
            }
            else {
                model.addAttribute("message", "wrong password");
                return "notFound";
            }
        }
        else {
            model.addAttribute("message", "not found login");
            return "notFound";
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homeForm(Model model, @ModelAttribute("message") String str, @ModelAttribute("user_session") User user) {
        model.addAttribute("log", new User());
        model.addAttribute("userSession", user);
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/homeAttr";
    }

}
