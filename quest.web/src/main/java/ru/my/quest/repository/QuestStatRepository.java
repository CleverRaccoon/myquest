package ru.my.quest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.my.quest.model.entity.QuestPK;
import ru.my.quest.model.entity.QuestStat;

/**
 * Created by maksim on 5/29/2016.
 */
public interface QuestStatRepository extends JpaRepository<QuestStat, QuestPK> {
}
