package br.com.firstcrud.firstcrud.api.mocks;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.firstcrud.firstcrud.api.errors.CustomException;

@Controller
@RequestMapping(value = "/exception")
public class FakeRestProcessingExceptionThrowingController {

  @GetMapping("/CustomException")
  public void fakeCustomException() throws CustomException {
    throw new CustomException("fake error", HttpStatus.BAD_REQUEST);
  }

  @PostMapping("/ValidException")
  public void fakeConstraintViolationException(
    @RequestBody @Valid FakeDTO fakeDTO
  ) throws Exception {}
}
