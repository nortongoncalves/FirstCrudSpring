package br.com.firstcrud.firstcrud.api.mocks;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class FakeDTO {
  @NotNull(message = "O nome não pode ser nulo")
  @Size(min = 1, max = 255, message = "O nome deve ser informado")
  private String name;

  @NotNull(message = "A descrição não pode ser nulo")
  @Size(min = 1, max = 255, message = "A descrição deve ser informado")
  private String description;

  @NotNull(message = "A senha não pode ser nulo")
  @Size(min = 6, max = 255, message = "A senha deve conter 6 digitos")
  private String password;

  public FakeDTO(String name, String description, String password) {
    this.name = name;
    this.description = description;
    this.password = password;
  }
}
