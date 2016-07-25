package ru.my.quest.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by maksim on 4/17/2016.
 */
@Data
@Entity(name="game_entity")
public class Game implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer organizatorId;
    @OneToMany(targetEntity = Team.class)
    @JoinColumn(name = "game", referencedColumnName = "id")
    private Set<Team> teamId;
    @OneToMany(targetEntity = Level.class)
    @JoinColumn(name = "level", referencedColumnName = "id")
    private List<Level> level;
    private Long startDate;
    private Long finishDate;
    private String country;
    private String region;
    private String city;
    private boolean autoFinish;
    private Long penalty;
    private Integer storyType;
    private boolean enabled;
    private String questDescribe;
    private Double price;
}
