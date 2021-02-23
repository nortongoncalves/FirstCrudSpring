package br.com.firstcrud.firstcrud.api.errors.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.firstcrud.firstcrud.api.apresentations.ResponseExceptionData;

@ControllerAdvice
public class MethodArgumentNotValidExceptionController {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ResponseExceptionData> handleDataIntegrityViolationException(MethodArgumentNotValidException err) {
    String fildErrorMessage = err.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    String message = "❌ Json mal formatado. " + fildErrorMessage;
    int statusCode = HttpStatus.BAD_REQUEST.value();
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    ResponseExceptionData responseExceptionData = new ResponseExceptionData(message, statusCode, httpStatus);
    return new ResponseEntity<ResponseExceptionData>(responseExceptionData, httpStatus);
  }
}
