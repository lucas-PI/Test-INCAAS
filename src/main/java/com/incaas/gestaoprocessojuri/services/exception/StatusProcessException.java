package com.incaas.gestaoprocessojuri.services.exception;

public class StatusProcessException extends IllegalArgumentException{
    public StatusProcessException(Object status) {
        super("o status do processo não permite a criação de audiencia " + status);
    }
}
