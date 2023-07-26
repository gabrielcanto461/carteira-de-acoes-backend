package br.com.stocksledger.controller;

import br.com.stocksledger.exception.PositionNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PositionControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> exception(RuntimeException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }
}
