package br.com.firstcrud.firstcrud.api.provider.Encrypt.implementation;

import static org.mindrot.jbcrypt.BCrypt.*;

import org.springframework.stereotype.Component;

import br.com.firstcrud.firstcrud.api.provider.Encrypt.IEncrypt;

@Component
public class Encrypt implements IEncrypt {
  @Override
  public String create(String password) {
    String hashed = hashpw(password, gensalt());
    return hashed;
  }

  @Override
  public Boolean compare(String password, String hashed) {
    return checkpw(password, hashed);
  }
}
