package ru.my.quest.converter;

import org.springframework.stereotype.Service;
import ru.my.quest.dto.GameDTO;
import ru.my.quest.model.entity.Game;
import ru.my.quest.repository.TeamRepository;

/**
 * Created by Maksim Zagorodskiy on 6/18/2016.
 */
@Service
public class GameConverterService {

    private TeamRepository teamRepository;
    public GameDTO convertGameToGameDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setStartDate(game.getStartDate());
        gameDTO.setFinishDate(game.getFinishDate());
        gameDTO.setDescription(game.getQuestDescribe());
        gameDTO.setPrice(game.getPrice());
        gameDTO.setQuestName(game.getName());
        gameDTO.setStoryType(game.getStoryType());

        //gameDTO.setRegisteredTeams();
        return gameDTO;
    }

}
