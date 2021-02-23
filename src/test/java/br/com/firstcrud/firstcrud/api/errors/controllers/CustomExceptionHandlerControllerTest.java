package br.com.firstcrud.firstcrud.api.errors.controllers;

import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.firstcrud.firstcrud.api.mocks.FakeRestProcessingExceptionThrowingController;

@WebMvcTest(controllers = {
  FakeRestProcessingExceptionThrowingController.class,
  CustomExceptionHandlerController.class
})
@DisplayName("CustomExceptionHandlerControllerTest")
public class CustomExceptionHandlerControllerTest {

  private final MockMvc mockMvc;

  @Autowired
  public CustomExceptionHandlerControllerTest(
    MockMvc mockMvc
    ) {
    this.mockMvc = mockMvc;
  }

  @Test
  @DisplayName("it must return a custom exception error")
  public void mustReturnCustomException() throws Exception {
    JSONObject jsonContent = new JSONObject();
    jsonContent.put("status", "Error");
    jsonContent.put("message", "fake error");
    jsonContent.put("statusCode", 400);
    jsonContent.put("httpStatus", "BAD_REQUEST");

    mockMvc
      .perform(MockMvcRequestBuilders.get("/exception/CustomException"))
      .andExpect(MockMvcResultMatchers.status().isBadRequest())
      .andExpect(MockMvcResultMatchers.content().json(jsonContent.toString()));
  }
}
