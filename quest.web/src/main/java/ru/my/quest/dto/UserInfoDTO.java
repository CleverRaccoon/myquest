package ru.my.quest.dto;

/**
 * Created by maksim on 6/4/2016.
 */
public class UserInfoDTO {
    public String login;
    public String password;
    public String role;

    public UserInfoDTO(String login, String role, String password) {
        this.login = login;
        this.role = role;
        this.password = password;
    }

    public UserInfoDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
