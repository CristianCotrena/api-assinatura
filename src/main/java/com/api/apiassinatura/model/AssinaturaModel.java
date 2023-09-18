package com.api.apiassinatura.model;

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
    private UUID id_Cliente;

    @Column(nullable = false)
    private UUID id_Plano;
    @Column(nullable = false, columnDefinition ="int default 1")
    private int status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(UUID id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public UUID getId_Plano() {
        return id_Plano;
    }

    public void setId_Plano(UUID id_Plano) {
        this.id_Plano = id_Plano;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}