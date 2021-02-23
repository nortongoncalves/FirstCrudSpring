package br.com.firstcrud.firstcrud.api.modules.professors.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.firstcrud.firstcrud.api.modules.professors.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {}
