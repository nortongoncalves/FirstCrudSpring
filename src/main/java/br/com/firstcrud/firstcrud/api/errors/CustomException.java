package br.com.firstcrud.firstcrud.api.errors;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class CustomException extends Exception {
  private static final long serialVersionUID = 1L;
  @Getter
  private String message;
  @Getter
  private HttpStatus httpStatus;

  public CustomException(String message) {
    this.message = message;
    this.httpStatus = HttpStatus.BAD_REQUEST;
  }

  public CustomException(String message, HttpStatus httpStatus) {
    this.message = message;
    this.httpStatus = httpStatus;
  }
}
