package com.nabilla.myasset.exception;

public class DataNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String customMessage) {
        super(customMessage);
    }
}
