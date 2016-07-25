package ru.my.quest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.my.quest.dto.UserInfoDTO;
import ru.my.quest.model.entity.Person;

import java.util.List;

/**
 * Created by maksim on 5/29/2016.
 */
public interface PersonRepository extends JpaRepository<Person, Integer > {

    @Query("Select new ru.my.quest.dto.UserInfoDTO(p.login, p.role, p.password) from Person p where p.login = :login")
    UserInfoDTO getUserInfo(@Param("login")String  login);

    Person findOneByLogin(String login);

    List<Person> findAllByTeam_Id(Integer teamId);

}
