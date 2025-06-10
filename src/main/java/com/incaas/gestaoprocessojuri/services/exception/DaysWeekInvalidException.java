package com.incaas.gestaoprocessojuri.services.exception;

public class DaysWeekInvalidException extends IllegalArgumentException{
    public DaysWeekInvalidException(Object dia) {
        super("dia invalido não poder ser fins de semana: " + dia);
    }
}
