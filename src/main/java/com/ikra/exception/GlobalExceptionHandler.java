package com.ikra.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.AbstractMap;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

   /* @ExceptionHandler(Exception.class)
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(Exception exception) {
        // general exception
        LOG.error("Exception: Unable to process this request. ", exception);
        AbstractMap.SimpleEntry<String, String> response =
                new AbstractMap.SimpleEntry<>("message", "Unable to process this request.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }*/

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(
            UserAlreadyExistException exception) {
        // general exception
        LOG.error("Exception: Unable to process this request. ", exception);
        AbstractMap.SimpleEntry<String, String> response = new AbstractMap.SimpleEntry<>("message",
                "Unable to process this request." + exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

   /* @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(
            MethodArgumentNotValidException exception) {
        // general exception
        LOG.error("Exception: Unable to process this request. ", exception);
        AbstractMap.SimpleEntry<String, String> response = new AbstractMap.SimpleEntry<>("message",
                "Unable to process this request." + exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }*/
}
