package br.com.firstcrud.firstcrud.api.apresentations;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ResponseExceptionData {
  private String status;
  private String message;
  private int statusCode;
  private HttpStatus httpStatus;

  public ResponseExceptionData(String message, int statusCode, HttpStatus httpStatus) {
    this.status = "Error";
    this.message = message;
    this.statusCode = statusCode;
    this.httpStatus = httpStatus;
  }
}
