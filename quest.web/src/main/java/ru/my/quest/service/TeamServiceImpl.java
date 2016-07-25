package ru.my.quest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.my.quest.model.entity.Person;
import ru.my.quest.model.entity.Team;
import ru.my.quest.repository.PersonRepository;
import ru.my.quest.repository.TeamRepository;

import java.util.List;

/**
 * Created by maksim on 6/10/2016.
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PersonRepository personRepository;


    @Override
    public void createTeam( String teamName, Integer captainId, String logoPath) {
        Team team = new Team();
        team.setName(teamName);
        team.setLogoPath(logoPath);
        team.setCaptainId(captainId);
        teamRepository.save(team);

    }

    @Override
    public void updateTeam(String teamName) {

    }

    @Override
    public void addParticipants(List<Integer> personsIds, String teamName){
       Team team = teamRepository.findFirstByName(teamName);
        for (Integer personId : personsIds) {
            Person person = personRepository.findOne(personId);
            person.setTeam(team);
            personRepository.save(person);
        }
    }

    @Override
    @Transactional
    public void deleteTeam(String teamName) {
        Team team = teamRepository.findFirstByName(teamName);
        teamRepository.delete(team);
        List<Person> persons = personRepository.findAll();
        for(Person person:persons){
            person.setTeam(null);
            person.setCaptain(false);
        }
        personRepository.save(persons);
    }

    public void deleteParticipant(Integer participantId) {
        Person person = personRepository.findOne(participantId);
        person.setTeam(null);
        personRepository.save(person);
    }
}
