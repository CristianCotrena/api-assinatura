package com.api.apiassinatura.repositories;

import com.api.apiassinatura.entities.models.AssinaturaModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssinaturaRepository extends JpaRepository<AssinaturaModel, UUID> {

  Optional<Boolean> existsByIdCliente(UUID idCliente);

  Optional<Boolean> existsByIdPlano(UUID idPlano);
}