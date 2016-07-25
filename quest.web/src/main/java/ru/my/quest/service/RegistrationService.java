package ru.my.quest.service;

import ru.my.quest.context.ServiceRepositoryResultContext;

import java.util.Locale;

/**
 * Created by maksim on 6/13/2016.
 */
public interface RegistrationService<T> {
    ServiceRepositoryResultContext<T> registerPerson(String login, String mail, String pass, Locale locale);

    // @Transactional(propagation = Propagation.REQUIRED)
    void innerTxTest();
}
