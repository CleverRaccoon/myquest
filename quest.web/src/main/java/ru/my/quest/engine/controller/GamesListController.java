package ru.my.quest.engine.controller;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.my.quest.dto.GameDTO;
import ru.my.quest.service.GameService;

import java.util.List;

/**
 * Класс контроллер для обработки AJAX запросов, дял оплучения списков доступных игр
 * Created by maksim on 6/13/2016.
 */
@Controller
public class GamesListController {
    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<GameDTO> getList(@RequestParam DateTime dateFrom, @RequestParam DateTime dateTo){
        List<GameDTO> list = gameService.getAvailableGameByPeriod(dateFrom.getMillis(), dateTo.getMillis());
        return list;
    }

}
