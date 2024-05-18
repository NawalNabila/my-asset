package com.nabilla.myasset.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String customMessage) {
        super(customMessage);
    }
}
