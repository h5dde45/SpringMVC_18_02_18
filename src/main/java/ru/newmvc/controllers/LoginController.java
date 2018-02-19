package ru.newmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.newmvc.objects.User;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("user") User user,
                                  BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "login";
        }
            return "main";
    }

    @RequestMapping(value = "failed", method = RequestMethod.GET)
    public ModelAndView failed() {
        return new ModelAndView("login_failed","message","login failed");
    }
}
