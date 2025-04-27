package com.studies.training.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.studies.training.exceptions.IdNotFoundException;
import com.studies.training.exceptions.InvalidInputException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    private ResponseEntity<String> idNotFoundHandler(IdNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Id não encontrado");
    }

    @ExceptionHandler(InvalidInputException.class)
    private ResponseEntity<String> InvalidInputHandler(InvalidInputException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campo não pode ser vazio");
    }
}
