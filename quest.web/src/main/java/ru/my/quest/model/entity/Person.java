package ru.my.quest.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by maksim on 4/17/2016.
 */
@Data
@Entity
@Table(name="person_entity")
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String nickname;
    @Column(unique = true)
    private String login;
    private String password;
    @Email
    @Column(unique = true)
    private String mail;
    private String phoneNumber;
    private boolean captain;
    private String role;
    private String salt;
    @ManyToOne
    private Team team;
    private Long regDate;
    private String avatarPath;
    private Integer completedGames;
}
