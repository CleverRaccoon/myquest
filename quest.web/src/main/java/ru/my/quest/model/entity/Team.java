package ru.my.quest.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by maksim on 4/17/2016.
 */
@Data
@Entity
@Table(name="team_entity")
public class Team implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Long createDate;
    private String logoPath;
    private String completedGames;
    private Integer captainId;

}
