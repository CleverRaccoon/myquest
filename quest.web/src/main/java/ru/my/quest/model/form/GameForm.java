package ru.my.quest.model.form;

import lombok.Data;

/**
 * Created by maksim on 6/11/2016.
 */
@Data
public class GameForm {

    private String name;
    private String organizatorLogin;
    private Long startDate;
    private Long finishDate;
    private boolean autoFinish;
    private Long penalty;
    private Integer storyType;


}
