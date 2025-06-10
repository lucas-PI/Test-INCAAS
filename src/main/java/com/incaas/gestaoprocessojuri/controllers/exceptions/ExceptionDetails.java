package com.incaas.gestaoprocessojuri.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class ExceptionDetails {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    protected Instant timestamp;
    protected Integer statusDetails;
    protected String error;
    protected String message;
    protected String path;

    public ExceptionDetails(Instant timestamp, Integer statusDetails, String error, String message, String path) {
        this.timestamp = timestamp;
        this.statusDetails = statusDetails;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public ExceptionDetails() {
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(Integer statusDetails) {
        this.statusDetails = statusDetails;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
