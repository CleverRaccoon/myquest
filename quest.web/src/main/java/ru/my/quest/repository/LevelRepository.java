package ru.my.quest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.my.quest.model.entity.Level;

/**
 * Created by maksim on 5/29/2016.
 */
public interface LevelRepository extends JpaRepository<Level, Integer > {
}
