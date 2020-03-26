package spm.spring.world.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // MethodArgumentNotValidException
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomerErrorDetails customerErrorDetails = new CustomerErrorDetails(new Date(), "from MethodArgumentNot Exception", ex.getMessage());
        return new ResponseEntity(customerErrorDetails, HttpStatus.BAD_REQUEST);
    }

    // HttpRequestMethodNotSupportedException
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomerErrorDetails customerErrorDetails = new CustomerErrorDetails(new Date(), "from HttpRequestMethodNotSupportedException in GEH - Method not allowed", ex.getMessage());
        return new ResponseEntity(customerErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }
    // UserNameNotFoundException
    /*@ExceptionHandler(UserNameNotFoundException.class)
    public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        CustomerErrorDetails customerErrorDetails = new CustomerErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(customerErrorDetails,HttpStatus.NOT_FOUND);
    }*/

    // ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> constraintViolationException(UserNameNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomerErrorDetails customerErrorDetails = new CustomerErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(customerErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
