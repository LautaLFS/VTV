package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.dto.ErrorResponse;
import com.certantchallenge.vtv.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest request){
        Map<String,String> errors = new HashMap<>();
        errors.put("Resource not found", ex.getMessage());
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST,errors);
        return handleExceptionInternal(ex,error,new HttpHeaders(),HttpStatus.BAD_REQUEST,request);
    }
}
