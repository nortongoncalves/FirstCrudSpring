package br.com.firstcrud.firstcrud.api.errors.controllers;

import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.firstcrud.firstcrud.api.apresentations.ResponseExceptionData;

@ControllerAdvice
public class ConstraintViolationExceptionHandlerController {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ResponseExceptionData> handleSqlSyntaxException(ConstraintViolationException err, WebRequest request) {
    String message = err.getMessage();
    int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    ResponseExceptionData responseExceptionData = new ResponseExceptionData(message, statusCode, httpStatus);
    return new ResponseEntity<ResponseExceptionData>(responseExceptionData, new HttpHeaders(), httpStatus);
  }
}
