package com.api.apiassinatura.entities.dtos;

import java.io.Serializable;

public class AssinaturaResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;
  private String id;

  public AssinaturaResponseDto(
      String id
  ) {
    this.id = id;
  }

  public String id() {
    return id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
