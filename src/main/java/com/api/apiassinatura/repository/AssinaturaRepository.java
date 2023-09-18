package com.api.apiassinatura.repository;

import com.api.apiassinatura.model.AssinaturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AssinaturaRepository extends JpaRepository<AssinaturaModel, UUID> {
}
