package spm.spring.client.exceptions;

/**
 *
 */
public class UserNotFoundException extends Exception {
    private static final long serialVersionID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
