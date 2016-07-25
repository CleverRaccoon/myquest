package ru.my.quest.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by maksim on 6/9/2016.
 */
@IdClass(QuestPK.class)
@Entity
@Data
@Table(name="quest_stat_entity")
public class QuestStat {
    @Id
    @Column(name = "quest_id")
    private Integer gameId;
    @Id
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "spend_time")
    private Long spendTime;

    @Column(name = "penalty_time")
    private Long penaltyTime;

}
