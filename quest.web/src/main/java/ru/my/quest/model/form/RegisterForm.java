package ru.my.quest.model.form;

import lombok.Data;

/**
 * Created by maksim on 6/6/2016.
 */
@Data
public class RegisterForm {
    private String login;
    private String password;
    private String mail;
}
