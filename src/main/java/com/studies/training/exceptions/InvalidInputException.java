package com.studies.training.exceptions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
        super("O campo não pode estar vazio");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
