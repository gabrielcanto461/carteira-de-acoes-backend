package br.com.stocksledger.exception;


public class PositionNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PositionNotFoundException(String message) {
        super(message);
    }
}
