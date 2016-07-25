package ru.my.quest.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by maksim on 4/17/2016.
 */
@Data
@Entity
@Table(name="level_entity")
public class Level implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Long startDate;
    private Long finishDate;
    private Long duration;
    private Long penalty;
    private String questionPicturePath;
    private String answerPicturePath;
    private String answer;
    private Long  questId;
    @OneToMany(targetEntity = Hint.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "level", referencedColumnName = "id")
    private List<Hint> hint;

}
