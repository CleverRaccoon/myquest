package ru.my.quest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.my.quest.model.form.RegisterForm;
import ru.my.quest.service.RegistrationService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by maksim on 6/6/2016.
 */
@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterForm(HttpServletRequest httpServletRequest){
        ModelAndView model = new ModelAndView();
        RegisterForm form = new RegisterForm();
        model.addObject("form", form);
        Map<String,String> map = new HashMap<>(100);
        model.addObject("address", map);
        model.setViewName("registration");
        return model;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerNewUser(@ModelAttribute RegisterForm form, ModelAndView model ){
        registrationService.registerPerson(form.getLogin(), form.getMail(), form.getPassword(), new Locale("ru"));
        ModelAndView model2 = new ModelAndView();
        model.setViewName("games");
        return model2;
    }
}
