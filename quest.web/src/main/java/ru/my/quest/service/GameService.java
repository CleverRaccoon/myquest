package ru.my.quest.service;

import org.springframework.transaction.annotation.Transactional;
import ru.my.quest.dto.GameDTO;
import ru.my.quest.model.entity.Hint;
import ru.my.quest.model.form.model.LevelForm;

import java.util.List;

/**
 * Created by maksim on 6/11/2016.
 */
public interface GameService  {

    @Transactional
    Integer createGame(Integer organizatorId, String name);

    @Transactional
    Integer compineGame(Integer id, List<LevelForm> levelForms, String describe);

    void addDescribe(Integer gameId, String describe);

    void confirmGame(Integer id);

    List<Hint> createHintsForLevel(LevelForm level);

    List<GameDTO> getAvailableGameByPeriod(Long startPeriod, Long endPeriod);


}
