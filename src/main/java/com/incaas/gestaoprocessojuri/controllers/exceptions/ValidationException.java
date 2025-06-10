package com.incaas.gestaoprocessojuri.controllers.exceptions;

import java.time.Instant;

public class ValidationException extends ExceptionDetails{

    private final String fields;
    private final String fieldsMessage;

    public ValidationException(Instant timestamp, Integer statusDetails, String error, String message, String path, String fields, String fieldsMessage) {
        super(timestamp,statusDetails,error,message,path);
        this.fields = fields;
        this.fieldsMessage = fieldsMessage;
    }

}
