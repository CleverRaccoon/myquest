package ru.my.quest.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Сервис для создания и обновелния сущностей команд
 * Created by maksim on 6/10/2016.
 */
public interface TeamService {

    @Transactional(rollbackFor = Exception.class)
    void createTeam( String teamName, Integer captainId, String logoPath);

    void updateTeam(String teamName);

    void addParticipants(List<Integer> personsIds, String teamName);

    void deleteTeam(String teamName);
}
