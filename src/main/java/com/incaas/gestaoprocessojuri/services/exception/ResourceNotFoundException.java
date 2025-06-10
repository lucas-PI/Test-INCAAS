package com.incaas.gestaoprocessojuri.services.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id) {
        super("recurso não encontrado pelo id " + id);
    }
}
