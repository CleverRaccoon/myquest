package ru.my.quest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.my.quest.repository.HintRepository;
import ru.my.quest.repository.PersonRepository;
import ru.my.quest.service.RegistrationService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyQuestApplication.class)
public class MyQuestApplicationTests {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    private HintRepository hintRepository;
    @Autowired
    private RegistrationService registrationService;

    @Test
    public void test(){
       hintRepository.deleteAll();
        registrationService.innerTxTest();
    }


    @Transactional
    private void commitHint(){

    }
}
