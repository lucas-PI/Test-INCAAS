package com.incaas.gestaoprocessojuri.controllers.exceptions;

import java.time.Instant;

public class StandardError extends ExceptionDetails{
    public StandardError(Instant timestamp, Integer statusDetails, String error, String message, String path) {
        super(timestamp, statusDetails, error, message, path);
    }
}
