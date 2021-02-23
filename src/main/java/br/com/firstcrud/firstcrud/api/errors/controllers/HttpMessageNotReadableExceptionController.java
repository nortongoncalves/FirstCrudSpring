package br.com.firstcrud.firstcrud.api.errors.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.firstcrud.firstcrud.api.apresentations.ResponseExceptionData;

@ControllerAdvice
public class HttpMessageNotReadableExceptionController {
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ResponseExceptionData> handleDataIntegrityViolationException(HttpMessageNotReadableException err) {
    String message = "❌ Json mal formatado. ";
    int statusCode = HttpStatus.BAD_REQUEST.value();
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    ResponseExceptionData responseExceptionData = new ResponseExceptionData(message, statusCode, httpStatus);
    return new ResponseEntity<ResponseExceptionData>(responseExceptionData, httpStatus);
  }
}
