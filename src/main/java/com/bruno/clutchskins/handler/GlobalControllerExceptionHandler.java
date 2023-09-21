package com.bruno.clutchskins.handler;

import com.bruno.clutchskins.exceptions.BadRequestException;
import com.bruno.clutchskins.exceptions.EntityNotFoundException;
import com.bruno.clutchskins.exceptions.ExceptionDetails;
import com.bruno.clutchskins.exceptions.InvalidFloatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> handlerBadRequestException(BadRequestException badRequestException) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, check the doc")
                        .errorMessage(badRequestException.getMessage())
                        .errorClass(badRequestException.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("The entity not found")
                        .errorMessage(entityNotFoundException.getMessage())
                        .errorClass(entityNotFoundException.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(InvalidFloatException.class)
    public ResponseEntity<ExceptionDetails> handlerInvalidFloatException(InvalidFloatException invalidFloatException) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Float invalid")
                        .errorMessage(invalidFloatException.getMessage())
                        .errorClass(invalidFloatException.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND
        );
    }

}
