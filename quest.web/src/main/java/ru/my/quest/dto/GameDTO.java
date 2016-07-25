package ru.my.quest.dto;

import lombok.Data;

/**
 * DTO для передачи параметров игры на View со списокм доступных игр
 * Created by maksim on 6/11/2016.
 */
@Data
public class GameDTO {

    String questName;
    int id;
    int storyType;
    String description;
    int registeredTeams;
    long startDate;
    long finishDate;
    String location;
    Double price;

}
