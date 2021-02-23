package br.com.firstcrud.firstcrud.api.modules.professors.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.firstcrud.firstcrud.api.errors.CustomException;
import br.com.firstcrud.firstcrud.api.modules.professors.DTOs.RequestCreateProfessorDTO;
import br.com.firstcrud.firstcrud.api.modules.professors.models.Professor;
import br.com.firstcrud.firstcrud.api.modules.professors.repositories.ProfessorRepository;
import br.com.firstcrud.firstcrud.api.provider.Encrypt.IEncrypt;
import br.com.firstcrud.firstcrud.api.provider.Encrypt.implementation.Encrypt;

@Service
public class CreateProfessorService {
  private final ProfessorRepository professorRepository;
  private final IEncrypt encrypt;

  @Autowired
  public CreateProfessorService(
    ProfessorRepository professorRepository,
    Encrypt encrypt
  ) {
    this.professorRepository = professorRepository;
    this.encrypt = encrypt;
  }

  @Transactional(rollbackOn = Exception.class)
  public Professor execute(RequestCreateProfessorDTO request) throws CustomException {
    Professor professor = new Professor(request);
    String hashedPassword = encrypt.create(professor.getPassword());
    professor.setPassword(hashedPassword);
    Professor createdProfessor = professorRepository.save(professor);
    return createdProfessor;
  }
}
