package br.com.firstcrud.firstcrud.api.provider.Encrypt;

public interface IEncrypt {
  public String create(String password);
  public Boolean compare(String password, String hashedPassword);
}
