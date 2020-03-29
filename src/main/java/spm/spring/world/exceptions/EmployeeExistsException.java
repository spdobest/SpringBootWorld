package spm.spring.world.exceptions;

public class EmployeeExistsException extends Exception {
    private static final long serialVersionID = 1L;

    public EmployeeExistsException(String message) {
        super(message);
    }
}