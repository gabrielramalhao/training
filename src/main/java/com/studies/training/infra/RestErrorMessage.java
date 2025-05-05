package com.studies.training.infra;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {

    private HttpStatus status;
    private Instant time;
    private String message;

    public RestErrorMessage() {

    }

    public RestErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.time = Instant.now();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Instant getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
