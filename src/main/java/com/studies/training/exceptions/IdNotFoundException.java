package com.studies.training.exceptions;

import java.util.NoSuchElementException;

public class IdNotFoundException extends NoSuchElementException {

    public IdNotFoundException() {
        super("Id não encontrado");
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
