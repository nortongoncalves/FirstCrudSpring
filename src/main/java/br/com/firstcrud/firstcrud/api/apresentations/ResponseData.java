package br.com.firstcrud.firstcrud.api.apresentations;

import java.util.List;

import lombok.Getter;

@Getter
public class ResponseData {
  private String status;
  private List<?> data;
  private int dataLength;

  public <datatype> ResponseData(List<datatype> data) {
    this.status = "success";
    this.data = data;
    this.dataLength = data.size();
  }
}
