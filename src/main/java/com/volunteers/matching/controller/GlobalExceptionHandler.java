package com.volunteers.matching.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.volunteers.matching.exception.NotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  protected @ResponseBody ErrorResponse handleNotFound(NotFoundException e) {
    return new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            e.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  protected @ResponseBody ErrorResponse handleNotValidArgs(MethodArgumentNotValidException e) {
    List<String> errors = e.getBindingResult().getFieldErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
    return new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            errors);
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  static class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private List<String> errors;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String error, String message, List<String> errors) {
      this.status = status;
      this.error = error;
      this.message = message;
      this.errors = errors;
    }

    public ErrorResponse(int status, String error, String message) {
      this.status = status;
      this.error = error;
      this.message = message;
    }

    public ErrorResponse(int status, String message, List<String> errors) {
      this.status = status;
      this.message = message;
      this.errors = errors;
    }

    public int getStatus() {
      return status;
    }

    public void setStatus(int status) {
      this.status = status;
    }

    public String getError() {
      return error;
    }

    public void setError(String error) {
      this.error = error;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public List<String> getErrors() {
      return errors;
    }

    public void setErrors(List<String> errors) {
      this.errors = errors;
    }
  }
}
