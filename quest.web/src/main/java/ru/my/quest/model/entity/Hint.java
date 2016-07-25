package ru.my.quest.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by maksim on 6/12/2016.
 */
@Data
@Entity
@Table(name = "hint_entity")
public class Hint implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private Integer priority;
    private String value;



}
