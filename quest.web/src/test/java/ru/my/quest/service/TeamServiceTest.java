package ru.my.quest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.my.quest.MyQuestApplication;
import ru.my.quest.model.entity.Person;
import ru.my.quest.repository.PersonRepository;
import ru.my.quest.repository.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyQuestApplication.class)
public class TeamServiceTest {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TeamRepository teamRepository;


    //@Before()
    public void prepareDB(){
        personRepository.deleteAll();
        teamRepository.deleteAll();
        for(int i = 0; i < 5; i++){
            Person person = new Person();
            person.setName("name" + i);
            person.setCompletedGames(0);
            personRepository.save(person);
        }
    }

    @Test
    public void testRepo(){
        //System.out.println(teamRepository.countRegistredTeamsByGameId(1));

    }

    @Test
    public void createTeam(){

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +personRepository.findAllByTeam_Id(4) + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Person> persons = personRepository.findAll();
        teamService.createTeam("Team 1", persons.get(0).getId(), "path");
        List<Integer> personsIds = getPersonsIds(persons);
        teamService.addParticipants(personsIds, "Team 1");
      //  System.out.println(personRepository.getUserInfo("1").getLogin());
    }

    private List<Integer> getPersonsIds(List<Person> persons){

        List<Integer> list = persons.stream().map(Person::getId).collect(Collectors.toList());

        return list;
    }
}
