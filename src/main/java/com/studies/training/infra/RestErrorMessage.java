package com.studies.training.infra;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {

    private HttpStatus status;
    private String time;
    private String message;

    public RestErrorMessage() {

    }

    public RestErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.time = formattedInstantTime();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getTime() {
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

    private String formattedInstantTime() {
        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of("GMT-3");
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        DateTimeFormatter dmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = zonedDateTime.format(dmt);
        return formattedTime;
    }
}
