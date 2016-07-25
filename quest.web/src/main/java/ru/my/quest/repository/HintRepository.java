package ru.my.quest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.my.quest.model.entity.Hint;

/**
 * Created by maksim on 6/12/2016.
 */
public interface HintRepository extends JpaRepository<Hint, Integer> {
}
