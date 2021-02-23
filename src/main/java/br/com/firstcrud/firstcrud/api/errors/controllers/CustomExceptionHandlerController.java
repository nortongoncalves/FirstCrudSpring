package br.com.firstcrud.firstcrud.api.errors.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import br.com.firstcrud.firstcrud.api.apresentations.ResponseExceptionData;
import br.com.firstcrud.firstcrud.api.errors.CustomException;

@ControllerAdvice
public class CustomExceptionHandlerController {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ResponseExceptionData> handleCustomException(CustomException err, WebRequest request) {
    String message = err.getMessage();
    int statusCode = err.getHttpStatus().value();
    HttpStatus httpStatus = err.getHttpStatus();

    ResponseExceptionData responseExceptionData = new ResponseExceptionData(message, statusCode, httpStatus);
    return new ResponseEntity<ResponseExceptionData>(responseExceptionData, new HttpHeaders(), err.getHttpStatus());
  }
}
