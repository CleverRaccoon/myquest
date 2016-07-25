package ru.my.quest.exception;

/**
 * Created by maksim on 6/9/2016.
 */
public class UserRegistrationException extends Exception {
    final int error = ExceptionConstants.USER_REGISTRATION_EXCEPTION;

   public int getErrorCode(){
        return error;
    }
}
