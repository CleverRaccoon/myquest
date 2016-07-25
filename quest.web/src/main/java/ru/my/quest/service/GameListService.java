package ru.my.quest.service;

import ru.my.quest.model.entity.Game;

import java.util.List;

/**
 * Класс сервич для поиска игр по параметрам
 * Created by Maksim Zagorodskiy on 6/17/2016.
 */
public interface GameListService {

    List<Game> getGameByPeriod(Long dateTo, Long dateFrom );
    List<Game> getGameByLocation(String country, String city);
    List<Game> getAllAvailableGame();

}
