package com.certantchallenge.vtv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private Map<String,String> errors;
}
