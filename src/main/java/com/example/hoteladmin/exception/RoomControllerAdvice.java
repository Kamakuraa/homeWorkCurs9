package com.example.hoteladmin.exception;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RoomControllerAdvice {
  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ApiError handleResourceNotFoundException(ResourceNotFoundException rnfe){
    return new ApiError (rnfe.getMessage ());
  }
}
@Value
class ApiError{
  String message;
}
