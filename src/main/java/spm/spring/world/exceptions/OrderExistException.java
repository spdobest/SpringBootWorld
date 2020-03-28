package spm.spring.world.exceptions;

public class OrderExistException extends Exception {
    private static final long serialVersionID = 1L;

    public OrderExistException(String message) {
        super(message);
    }
}
