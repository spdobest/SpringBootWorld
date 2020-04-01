package spm.spring.client.exceptions;

public class OrderExistException extends Exception {
    private static final long serialVersionID = 1L;

    public OrderExistException(String message) {
        super(message);
    }
}
