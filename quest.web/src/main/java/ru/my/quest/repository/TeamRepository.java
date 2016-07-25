package ru.my.quest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.my.quest.model.entity.Team;

/**
 * Created by maksim on 5/29/2016.
 */
public interface TeamRepository extends JpaRepository<Team, Integer > {

    Team findFirstByName(String name);


}
