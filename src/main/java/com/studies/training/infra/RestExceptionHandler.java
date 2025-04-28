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
    private ResponseEntity<RestErrorMessage> idNotFoundHandler(IdNotFoundException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,
                "Id não encontrado");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatResponse);
    }

    @ExceptionHandler(InvalidInputException.class)
    private ResponseEntity<RestErrorMessage> InvalidInputHandler(InvalidInputException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST,
                "O campo não pode estar vazio");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
}
