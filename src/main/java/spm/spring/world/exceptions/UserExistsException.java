package spm.spring.world.exceptions;

public class UserExistsException extends Exception {
    private static final long serialVersionID = 1L;

    public UserExistsException(String message) {
        super(message);
    }
}