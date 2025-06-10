package com.incaas.gestaoprocessojuri.services.exception;

public class LocalAndVaraArgumentException extends IllegalArgumentException{
    public LocalAndVaraArgumentException(Object vara, Object local) {
        super("local: " + local + " vara: " + vara + " ja estão ocupados neste mesmo horario e dia" );
    }
}
