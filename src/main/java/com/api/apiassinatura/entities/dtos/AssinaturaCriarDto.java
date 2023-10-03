package com.api.apiassinatura.entities.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public class AssinaturaCriarDto {

  @Schema(
      description = "Id do cliente",
      example = "123e4567-e89b-12d3-a456-426614174000"
  )
  private UUID idCliente;
  @Schema(
      description = "Id do plano",
      example = "123e4567-e89b-12d3-a456-426614174000"
  )
  private UUID idPlano;
  @Schema(
      description = "Status da assinatura",
      example = "1"
  )
  private Integer status;

  public AssinaturaCriarDto(
      UUID idCliente,
      UUID idPlano,
      Integer status
  ) {
    this.idCliente = idCliente;
    this.idPlano = idPlano;
    this.status = status;
  }

  public AssinaturaCriarDto() {
  }

  public UUID getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(UUID idCliente) {
    this.idCliente = idCliente;
  }

  public UUID getIdPlano() {
    return idPlano;
  }

  public void setIdPlano(UUID idPlano) {
    this.idPlano = idPlano;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
