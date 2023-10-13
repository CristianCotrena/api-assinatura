package com.api.apiassinatura.entities.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "ASSINATURAS")
public class AssinaturaModel implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @Column(nullable = false)
  private UUID idCliente;

  @Column(nullable = false)
  private UUID idPlano;
  @Column
  private Integer status;

  public AssinaturaModel(
      UUID id,
      UUID idCliente,
      UUID idPlano,
      Integer status
  ) {
    this.id = id;
    this.idCliente = idCliente;
    this.idPlano = idPlano;
    this.status = status;
  }

  public AssinaturaModel() {

  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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