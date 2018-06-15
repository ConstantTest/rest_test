package com.alex.rest.service.exceptions;

public class InvalidParameterException extends Exception {

    private static final long serialVersionUID = 12345678990999L;

    public InvalidParameterException(String message) {
        super(message);
    }
}
