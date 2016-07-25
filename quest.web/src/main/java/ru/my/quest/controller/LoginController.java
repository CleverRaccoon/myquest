package ru.my.quest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by maksim on 6/5/2016.
 */
@Controller
public class LoginController {
    @RequestMapping(value ="/login",  method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout){

        ModelAndView model = new ModelAndView();

        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;
    }

    @RequestMapping(value ="/login",  method = RequestMethod.POST)
    public ModelAndView login(){

        ModelAndView model = new ModelAndView();
        model.setViewName("play");

        return model;
    }
}
