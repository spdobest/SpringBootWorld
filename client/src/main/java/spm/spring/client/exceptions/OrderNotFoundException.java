package spm.spring.client.exceptions;

public class OrderNotFoundException extends Exception {
    private static final long serialVersionID = 1L;

    public OrderNotFoundException(String message) {
        super(message);
    }
}

