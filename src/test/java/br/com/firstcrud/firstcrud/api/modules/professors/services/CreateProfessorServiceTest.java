package br.com.firstcrud.firstcrud.api.modules.professors.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.firstcrud.firstcrud.api.modules.professors.DTOs.RequestCreateProfessorDTO;
import br.com.firstcrud.firstcrud.api.modules.professors.models.Professor;

@SpringBootTest
@DisplayName("CreateProfessorServiceTest")
public class CreateProfessorServiceTest {

  private final CreateProfessorService createProfessorService;

  @Autowired
  public CreateProfessorServiceTest(
    CreateProfessorService createProfessorService
  ) {
    this.createProfessorService = createProfessorService;
  }

  public void executeAllTests() throws Exception{
    mustBeAbleToRegisterProfessor();
  }

  @Test
  @DisplayName("it must be able to register a new professor")
  public void mustBeAbleToRegisterProfessor() throws Exception {
    RequestCreateProfessorDTO professor = new RequestCreateProfessorDTO("johndoe", "johndoe@johndoe.com", "123456",
        "www.johndoe.com", "eu sou o john doe");
        Professor createdProfessor = createProfessorService.execute(professor);
    assertEquals("johndoe", String.valueOf(createdProfessor.getName()));
  }

  @Test
  @DisplayName("must not return the professor with password not encrypted")
  public void mustNotReturnTheProfessorsWithPasswordNotEncrypted() throws Exception {
    RequestCreateProfessorDTO professor = new RequestCreateProfessorDTO("johndoe", "johndoe@johndoe.com", "123456",
        "www.johndoe.com", "eu sou o john doe");

    Professor createdProfessor = createProfessorService.execute(professor);
    assertNotEquals("123456", createdProfessor.getPassword());

  }
}
