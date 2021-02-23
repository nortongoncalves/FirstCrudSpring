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
  HttpMessageNotReadableExceptionController.class
})
@DisplayName("HttpMessageNotReadableExceptionControllerTests")
public class HttpMessageNotReadableExceptionControllerTests {

  private final MockMvc mockMvc;

  @Autowired
  public HttpMessageNotReadableExceptionControllerTests(
    MockMvc mockMvc
  ) {
    this.mockMvc = mockMvc;
  }

  @Test
  @DisplayName("it must return a HttpMessageNotReadableException error")
  public void mustReturnHttpMessageNotReadableException() throws Exception {
    JSONObject jsonContent = new JSONObject();
    jsonContent.put("status", "Error");
    jsonContent.put("message", "❌ Json mal formatado. ");
    jsonContent.put("statusCode", 400);
    jsonContent.put("httpStatus", "BAD_REQUEST");



    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/exception/ValidException")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{name: 'teste'}"))
      .andExpect(MockMvcResultMatchers.status().isBadRequest())
      .andExpect(MockMvcResultMatchers.content().json(jsonContent.toString()));
  }
}
