package br.com.firstcrud.firstcrud.api.modules.professors.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.firstcrud.firstcrud.api.modules.professors.DTOs.RequestCreateProfessorDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "public", name = "professors")
public class Professor {

  @Id
  private UUID id;

  @Type(type = "org.hibernate.type.StringType")
  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Type(type = "org.hibernate.type.StringType")
  @Column(name = "email", nullable = false, length = 255)
  private String email;

  @Type(type = "org.hibernate.type.StringType")
  @Column(name = "password", nullable = false, length = 255)
  private String password;

  @Type(type = "org.hibernate.type.TextType")
  @Column(name = "avatar_link", nullable = false)
  private String avatarLink;


  @Type(type = "org.hibernate.type.TextType")
  @Column(name = "biography", nullable = false)
  private String biography;

  public Professor(RequestCreateProfessorDTO request) {
    this.id = UUID.randomUUID();
    this.name = request.getName();
    this.email = request.getEmail();
    this.password = request.getPassword();
    this.avatarLink = request.getAvatarLink();
    this.biography = request.getBiography();
  }

  public Professor() {}
}
