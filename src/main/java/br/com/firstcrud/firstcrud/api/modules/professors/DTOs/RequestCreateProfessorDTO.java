package br.com.firstcrud.firstcrud.api.modules.professors.DTOs;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCreateProfessorDTO {
  @NotNull(message = "O nome deve ser informado")
  @Size(min = 1, max = 255, message = "O nome deve ser informado")
  private String name;

  @NotNull(message = "O email deve ser informado")
  @Size(min = 1, max = 255, message = "O email deve ser informado")
  private String email;

  @NotNull(message = "A senha deve deve conter no minimo 6 caracteres")
  @Size(min = 6, max = 255, message = "A senha deve deve conter no minimo 6 caracteres")
  private String password;

  private String avatarLink;

  private String biography;

  public RequestCreateProfessorDTO(
    String name,
    String email,
    String password,
    String avatarLink,
    String biography
  ) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.avatarLink = avatarLink;
    this.biography = biography;
  }
}
