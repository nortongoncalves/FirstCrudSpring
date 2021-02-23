package br.com.firstcrud.firstcrud.api.modules.professors.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.firstcrud.firstcrud.api.modules.professors.models.Professor;
import br.com.firstcrud.firstcrud.api.modules.professors.repositories.ProfessorRepository;

@Service
public class FindAllProfessorService {
  private final ProfessorRepository professorRepository;

  @Autowired
  public FindAllProfessorService(ProfessorRepository professorRepository) {
    this.professorRepository = professorRepository;
  }

  public List<Professor> execute() {
    return professorRepository.findAll();
  }
}
