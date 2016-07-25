package ru.my.quest.service;

import ru.my.quest.model.entity.Game;

import java.util.List;

/**
 * Created by Maksim Zagorodskiy on 6/17/2016.
 */
public class GameListServiceImpl implements GameListService {
    @Override
    public List<Game> getGameByPeriod(Long dateTo, Long dateFrom) {
        return null;
    }

    @Override
    public List<Game> getGameByLocation(String country, String city) {
        return null;
    }

    @Override
    public List<Game> getAllAvailableGame() {
        return null;
    }
}
