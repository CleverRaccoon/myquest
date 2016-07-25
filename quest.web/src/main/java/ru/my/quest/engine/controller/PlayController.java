package ru.my.quest.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.my.quest.model.entity.Team;
import ru.my.quest.repository.PersonRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Maksim Zagorodskiy on 6/16/2016.
 */
@Controller
public class PlayController {
    @Autowired
    private PersonRepository personRepository;

    //Мои игры
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public void myGames() {
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public ModelAndView play(HttpServletRequest request, HttpServletResponse response) {
        String gameId = request.getParameter("quest");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = ((UsernamePasswordAuthenticationToken)authentication);
        String userName = usernamePasswordAuthenticationToken.getName();
        Team team = personRepository.findOneByLogin(userName).getTeam();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("play");
        return modelAndView;
    }


}
