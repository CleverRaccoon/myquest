package ru.my.quest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.my.quest.model.entity.Game;

/**
 * Created by maksim on 5/29/2016.
 */
public interface GameRepository extends JpaRepository<Game, Integer > {
}
