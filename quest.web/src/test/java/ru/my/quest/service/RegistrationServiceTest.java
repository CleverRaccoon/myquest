package ru.my.quest.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.my.quest.MyQuestApplication;
import ru.my.quest.context.ServiceRepositoryResultContext;
import ru.my.quest.repository.PersonRepository;

import java.util.Locale;

import static ru.my.quest.exception.ExceptionConstants.ALL_IS_OK;


/**
 * Created by maksim on 6/9/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyQuestApplication.class)
public class RegistrationServiceTest {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    RegistrationService registrationService;

    @Test
    public void registrationNewUserTest() {
        ServiceRepositoryResultContext<Integer> result = registrationService.registerPerson("raccoon", "mail@mail.com", "123123", new Locale("ru"));
        Assert.assertEquals("Ошибка записи пользователя в БД", ALL_IS_OK.intValue(), result.getError());
        //personRepository.delete(result.getId());
        //Assert.assertEquals(0,personRepository.findOne(result.getId()));

    }
}
