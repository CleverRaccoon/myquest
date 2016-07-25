package ru.my.quest.model.form.model;

import lombok.Data;

import java.util.TreeMap;

/**
 * Created by maksim on 6/12/2016.
 */
@Data
public class LevelForm {
    private int number;
    private String question;
    private String answer;
    private Long duration;
    private TreeMap<Integer,String> hint;


}
