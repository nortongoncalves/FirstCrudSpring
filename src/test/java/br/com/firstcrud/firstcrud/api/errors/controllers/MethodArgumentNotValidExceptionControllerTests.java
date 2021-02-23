package br.com.firstcrud.firstcrud.api.errors.controllers;

import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.firstcrud.firstcrud.api.mocks.FakeDTO;
import br.com.firstcrud.firstcrud.api.mocks.FakeRestProcessingExceptionThrowingController;

@WebMvcTest(controllers = {
  FakeRestProcessingExceptionThrowingController.class,
  FakeDTO.class,
  MethodArgumentNotValidExceptionController.class
})
@DisplayName("MethodArgumentNotValidExceptionControllerTests")
public class MethodArgumentNotValidExceptionControllerTests {

  private final MockMvc mockMvc;

  @Autowired
  public MethodArgumentNotValidExceptionControllerTests(
    MockMvc mockMvc
  ) {
    this.mockMvc = mockMvc;
  }

  @Test
  @DisplayName("it must return a MethodArgumentNotValidException error")
  public void mustReturnMethodArgumentNotValidException() throws Exception {
    JSONObject jsonContent = new JSONObject();
    jsonContent.put("status", "Error");
    jsonContent.put("message", "❌ Json mal formatado. A senha deve conter 6 digitos");
    jsonContent.put("statusCode", 400);
    jsonContent.put("httpStatus", "BAD_REQUEST");

    JSONObject jsonRequest = new JSONObject();
    jsonRequest.put("name", "johndoe");
    jsonRequest.put("description", "descrição");
    jsonRequest.put("password", "12345");

    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/exception/ValidException")
          .contentType(MediaType.APPLICATION_JSON)
          .content(jsonRequest.toString()))
      .andExpect(MockMvcResultMatchers.status().isBadRequest())
      .andExpect(MockMvcResultMatchers.content().json(jsonContent.toString()));
  }
}
