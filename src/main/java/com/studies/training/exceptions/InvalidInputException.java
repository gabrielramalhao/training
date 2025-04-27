package com.studies.training.exceptions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
        super("Os dados não podem estar vazios");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
