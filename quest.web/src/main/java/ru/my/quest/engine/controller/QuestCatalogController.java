package ru.my.quest.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.my.quest.model.entity.Game;
import ru.my.quest.repository.GameRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Класс обработчик запросов на начало игры
 * Created by maksim on 6/13/2016.
 */
@Controller
public class QuestCatalogController {
    @Autowired
    private GameRepository gameRepository;

    @RequestMapping(value = "/quest", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest httpServletRequest){
        ModelAndView model = new ModelAndView("games");
        return model;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Game> getList(HttpServletRequest httpServletRequest, @RequestParam  String dateFrom){

        List<Game> list = gameRepository.findAll();
        return list;
    }

}
