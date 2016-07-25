package ru.my.quest.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by maksim on 6/9/2016.
 */
@Data
@EqualsAndHashCode
public class LevelPK implements Serializable{
    private Integer levelId;
    private Integer teamId;
}
