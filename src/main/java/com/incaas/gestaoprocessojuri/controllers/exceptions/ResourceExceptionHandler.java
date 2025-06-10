package com.incaas.gestaoprocessojuri.controllers.exceptions;

import com.incaas.gestaoprocessojuri.services.exception.DaysWeekInvalidException;
import com.incaas.gestaoprocessojuri.services.exception.LocalAndVaraArgumentException;
import com.incaas.gestaoprocessojuri.services.exception.ResourceNotFoundException;
import com.incaas.gestaoprocessojuri.services.exception.StatusProcessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        return new ResponseEntity<>(new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(),"resource Not Found",
                e.getMessage(),request.getRequestURI()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LocalAndVaraArgumentException.class)
    public ResponseEntity<StandardError> localAndVaraArgumentException (LocalAndVaraArgumentException e, HttpServletRequest request){
        return new ResponseEntity<>(new StandardError(Instant.now(),HttpStatus.BAD_REQUEST.value(),
                "argumentos passados na vara e local",e.getMessage(),request.getRequestURI()),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(StatusProcessException.class)
    public ResponseEntity<StandardError> statusProcessException(StatusProcessException e, HttpServletRequest request){
        return new ResponseEntity<>(new StandardError(Instant.now(),HttpStatus.BAD_REQUEST.value(),
                "o processo não pode esta suspenso ou arquivado",e.getMessage(),request.getRequestURI()),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DaysWeekInvalidException.class)
    public ResponseEntity<StandardError> daysWeekInvalid(DaysWeekInvalidException e, HttpServletRequest request){
        return new ResponseEntity<>(new StandardError(Instant.now(),HttpStatus.BAD_REQUEST.value(),"não pode marca uma audiencia em fins de semana",
                e.getMessage(),request.getRequestURI()),HttpStatus.BAD_REQUEST);
    }
}
