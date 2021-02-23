package br.com.firstcrud.firstcrud.api.modules.professors.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.firstcrud.firstcrud.api.modules.professors.DTOs.RequestCreateProfessorDTO;
import br.com.firstcrud.firstcrud.api.modules.professors.DTOs.ResponseCreateProfessorDTO;
import br.com.firstcrud.firstcrud.api.modules.professors.models.Professor;
import br.com.firstcrud.firstcrud.api.modules.professors.services.CreateProfessorService;

@RestController
@RequestMapping(value = "/professors", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreateProfessorController {
  private final CreateProfessorService createProfessorService;

  @Autowired
  public CreateProfessorController(CreateProfessorService createProfessorService) {
    this.createProfessorService = createProfessorService;
  }

  @PostMapping
  public ResponseEntity<ResponseCreateProfessorDTO> createUserController(@RequestBody @Valid RequestCreateProfessorDTO request) throws Exception {
    Professor professor = createProfessorService.execute(request);
    ResponseCreateProfessorDTO responseProfessor = new ResponseCreateProfessorDTO(professor);
    return new ResponseEntity<ResponseCreateProfessorDTO>(responseProfessor, HttpStatus.CREATED);
  }
}
