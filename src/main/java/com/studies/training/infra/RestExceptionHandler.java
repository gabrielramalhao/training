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
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        RestErrorMessage threatResponse = new RestErrorMessage(status,
                exception.getMessage());
        return ResponseEntity.status(status).body(threatResponse);
    }

    @ExceptionHandler(InvalidInputException.class)
    private ResponseEntity<RestErrorMessage> InvalidInputHandler(InvalidInputException exception) {
        var status = HttpStatus.BAD_REQUEST;
        RestErrorMessage threatResponse = new RestErrorMessage(status,
                exception.getMessage());
        return ResponseEntity.status(status).body(threatResponse);
    }
}
