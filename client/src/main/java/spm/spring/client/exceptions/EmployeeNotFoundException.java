package spm.spring.client.exceptions;


public class EmployeeNotFoundException extends Exception {
    private static final long serialVersionID = 1L;

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}