package br.com.firstcrud.firstcrud.api.errors.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.firstcrud.firstcrud.api.apresentations.ResponseExceptionData;

@ControllerAdvice
public class DataIntegrityViolationExceptionController {

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ResponseExceptionData> handleDataIntegrityViolationException(DataIntegrityViolationException err) {
    String message = "Erro de banco ❌ (" + err.getMessage() + " )";
    int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    ResponseExceptionData responseExceptionData = new ResponseExceptionData(message, statusCode, httpStatus);
    return new ResponseEntity<ResponseExceptionData>(responseExceptionData, httpStatus);
  }

}
