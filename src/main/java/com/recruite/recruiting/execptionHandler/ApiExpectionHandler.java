package com.recruite.recruiting.execptionHandler;

import com.recruite.recruiting.execptionHandler.execptionsData.BodyMissingExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Date;

@RestControllerAdvice
public class ApiExpectionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleMissingRequestBody(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new BodyMissingExecption(Date.from(Instant.now()),400, HttpStatus.BAD_REQUEST, "All fields are required" ), HttpStatus.BAD_REQUEST);
    }

}

