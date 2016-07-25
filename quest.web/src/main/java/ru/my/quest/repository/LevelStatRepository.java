package ru.my.quest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.my.quest.model.entity.Level;
import ru.my.quest.model.entity.LevelPK;

/**
 * Created by maksim on 5/29/2016.
 */
public interface LevelStatRepository extends JpaRepository<Level, LevelPK> {
}
