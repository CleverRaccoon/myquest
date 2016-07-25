package ru.my.quest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.my.quest.MyQuestApplication;
import ru.my.quest.context.ServiceRepositoryResultContext;
import ru.my.quest.model.form.model.LevelForm;
import ru.my.quest.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/**
 * Created by maksim on 6/14/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyQuestApplication.class)
public class GameServiceTest {
    @Autowired
    private GameService gameService;
    @Autowired
    private LevelService levelService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    RegistrationService registrationService;

    @Test
    public void createGameTest() {
        ServiceRepositoryResultContext<Integer> context = registrationService.registerPerson("master", "master@mail.com", "123123", new Locale("ru"));
        Integer gameId = gameService.createGame(context.getId(), "Пропажа драгоценностей баронессы");
        List<LevelForm> levelForms = createLevelForms();
        String describe = "Изящный квест, для любителей острых ощущений и заковыристых задач";
        gameService.compineGame(gameId, createLevelForms(),describe);
    }

    private List<LevelForm> createLevelForms() {
        List<LevelForm> levels = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            LevelForm levelForm = new LevelForm();
            levelForm.setAnswer("ответ" + i);
            levelForm.setDuration(1231231L);
            levelForm.setNumber(i);
            levelForm.setQuestion("Где драгоценности, ядрен батон 2?");
            TreeMap<Integer, String> hint = new TreeMap<>();
            hint.put(1, "Подсказка 1");
            hint.put(2, "Подсказка 2");
            levelForm.setHint(hint);
            levels.add(levelForm);
        }
        return levels;
    }

}
