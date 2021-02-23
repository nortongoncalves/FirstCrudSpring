package br.com.firstcrud.firstcrud.api.modules.professors.DTOs;

import java.util.UUID;

import br.com.firstcrud.firstcrud.api.modules.professors.models.Professor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCreateProfessorDTO {
  private UUID id;
  private String name;
  private String email;

  public ResponseCreateProfessorDTO(Professor professor) {
    this.id = professor.getId();
    this.name = professor.getName();
    this.email = professor.getEmail();
  }

  public ResponseCreateProfessorDTO(UUID id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }
}
