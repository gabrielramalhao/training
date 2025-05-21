package com.studies.training.exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("Necessário nível de acesso: Administrativo");
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
