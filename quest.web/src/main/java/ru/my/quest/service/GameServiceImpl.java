package ru.my.quest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.my.quest.dto.GameDTO;
import ru.my.quest.model.entity.Game;
import ru.my.quest.model.entity.Hint;
import ru.my.quest.model.entity.Level;
import ru.my.quest.model.form.model.LevelForm;
import ru.my.quest.repository.GameRepository;
import ru.my.quest.repository.HintRepository;
import ru.my.quest.repository.LevelRepository;

import java.util.*;

/**
 * Класс для работы с сущностью Game
 * Created by maksim on 6/11/2016.
 */
@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private HintRepository hintRepository;

    @Override
    @Transactional
    public Integer createGame(Integer organizatorId, String name) {
        Game game = new Game();
        game.setOrganizatorId(organizatorId);
        game = gameRepository.save(game);
        return game.getId();
    }

    @Override
    @Transactional
    public Integer compineGame(Integer id, List<LevelForm> levelForms, String describe) {
        List<Level> levels = new ArrayList<Level>();
        for (LevelForm level : levelForms) {
            Level levelEntity = new Level();
            levelEntity.setHint(createHintsForLevel(level));
            levelEntity.setAnswer(level.getAnswer());
            levelEntity.setDuration(level.getDuration());
            levelEntity = levelRepository.save(levelEntity);
            levels.add(levelEntity);
        }
        Game game = gameRepository.findOne(id);
        game.setLevel(levels);
        game.setQuestDescribe(describe);
        game.setEnabled(false);
        game = gameRepository.save(game);
        return game.getId();
    }

    @Override
    public void addDescribe(Integer gameId, String describe) {
        Game game = gameRepository.findOne(gameId);
        game.setQuestDescribe(describe);
        gameRepository.save(game);
    }


    @Override
    public void confirmGame(Integer id) {
        Game game = gameRepository.findOne(id);
        game.setEnabled(true);
    }

    public void discardGame(Integer id) {

        gameRepository.delete(id);
    }

    @Override
    public List<Hint> createHintsForLevel(LevelForm level) {
        List<Hint> result = new ArrayList<Hint>();
        Set<Map.Entry<Integer, String>> entry = level.getHint().entrySet();
        Iterator iter = entry.iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, String> hintEntry = (Map.Entry<Integer, String>) iter.next();
            Hint hint = new Hint();
            hint.setPriority(hintEntry.getKey());
            hint.setValue(hintEntry.getValue());
            hint = hintRepository.save(hint);
            result.add(hint);
        }
        return result;
    }

    @Override
    public List<GameDTO> getAvailableGameByPeriod(Long startPeriod, Long endPeriod) {
        return null;
    }

}
