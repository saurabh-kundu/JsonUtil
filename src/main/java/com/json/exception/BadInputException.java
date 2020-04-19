package com.json.exception;

public class BadInputException extends RuntimeException {

    public BadInputException(Exception ex) {
        super(ex);
    }

    public BadInputException(String message, Exception ex) {
        super(message, ex);
    }
}
