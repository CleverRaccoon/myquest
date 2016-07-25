package ru.my.quest.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.my.quest.context.ServiceRepositoryResultContext;
import ru.my.quest.exception.ExceptionConstants;
import ru.my.quest.model.entity.Hint;
import ru.my.quest.model.entity.Person;
import ru.my.quest.repository.HintRepository;
import ru.my.quest.repository.PersonRepository;
import ru.my.quest.utils.time.TimeConstants;
import ru.my.quest.utils.time.TimeUtils;

import java.util.Locale;

/**
 * Created by maksim on 6/6/2016.
 */
@Service
@Log4j
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private HintRepository hintRepository;

    @Override
    public ServiceRepositoryResultContext<Integer> registerPerson(String login, String mail, String pass, Locale locale){
        Person person = new Person();
        person.setLogin(login);
        person.setMail(mail);
        person.setPassword(passwordEncoder.encode(pass));
        person.setCompletedGames(0);
        person.setRole("ROLE_TEST");
        person.setRegDate(TimeUtils.getCurrentTimeByTimeZone(TimeConstants.UTC));
        ServiceRepositoryResultContext result = new ServiceRepositoryResultContext();
        try {
            Person entity =personRepository.save(person);
            result.setId(entity.getId());
            result.setError(ExceptionConstants.ALL_IS_OK);
            return result;
        } catch (Exception e){
            log.error(e.getMessage());
            Integer errorCode = ExceptionConstants.USER_REGISTRATION_EXCEPTION;
            log.error( ExceptionConstants.USER_REGISTRATION_EXCEPTION+ " :" +
                    messageSource.getMessage(errorCode.toString(), null, locale));
            result.setError(errorCode);
            return result;
        }
    }


    @Transactional
    @Override
    public void innerTxTest(){
        innerCommit();
        Person person = new Person();
        person.setLogin("loginochek");
        person.setMail("mail@mail.com");
        person.setCompletedGames(0);
        if(true){
            throw new RuntimeException();
        }
        personRepository.save(person);
    }

    public void innerCommit(){
        personRepository.deleteAll();
        hintRepository.deleteAll();

        Hint hint = new Hint();
        hint.setPriority(1);
        hint.setValue("value");
        hintRepository.save(hint);
    }

}
