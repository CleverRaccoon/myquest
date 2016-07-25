package ru.my.quest.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by maksim on 6/9/2016.
 */
@IdClass(LevelPK.class)
@Entity
@Data
@Table(name = "level_stat_entity")
public class LevelStat implements Serializable{
    @Id
    @Column(name = "level_id")
    private Integer levelId;
    @Id
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "spend_time")
    private Long spendTime;

    @Column(name = "penalty_time")
    private Long penaltyTime;
}
