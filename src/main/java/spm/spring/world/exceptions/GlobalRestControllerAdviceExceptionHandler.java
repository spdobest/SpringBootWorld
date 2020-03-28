package spm.spring.world.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {

    @ExceptionHandler(UserNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomerErrorDetails usernameNotFoundException(UserNameNotFoundException ex) {
        return new CustomerErrorDetails(new Date(), "From @RestControllerAdvice NOT FOUND", ex.getMessage());
    }

}
