package com.api.apiassinatura.services.v1;

import com.api.apiassinatura.base.dtos.BaseErrorDto;
import com.api.apiassinatura.builders.ResponseErrorBuilder;
import com.api.apiassinatura.builders.ResponseSuccessBuilder;
import com.api.apiassinatura.entities.dtos.AssinaturaRequestDto;
import com.api.apiassinatura.entities.dtos.AssinaturaResponseDto;
import com.api.apiassinatura.entities.models.AssinaturaModel;
import com.api.apiassinatura.repositories.AssinaturaRepository;
import com.api.apiassinatura.transform.AssinaturaModelTransform;
import com.api.apiassinatura.validations.CriarAssinaturaValidate;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaService {

  private AssinaturaRepository assinaturaRepository;

  @Autowired
  public AssinaturaService(AssinaturaRepository assinaturaRepository) {
    this.assinaturaRepository = assinaturaRepository;
  }

  @Transactional
  public ResponseEntity criarAssinatura(AssinaturaRequestDto novaAssinaturaDto) {
    List<BaseErrorDto> erros = new CriarAssinaturaValidate().validar(novaAssinaturaDto);

    if (erros.size() > 0) {
      return new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, erros).get();
    }

    Optional<Boolean> existsByIdCliente = assinaturaRepository.existsByIdCliente(
        novaAssinaturaDto.getIdCliente());

    if (existsByIdCliente.isPresent() && existsByIdCliente.get()) {
      return new ResponseErrorBuilder(HttpStatus.BAD_REQUEST,
          "Cliente já cadastrado na assinatura!").get();
    }

    AssinaturaModel novaAssinatura;
    novaAssinatura = new AssinaturaModelTransform().transformarAssinaturaModel(novaAssinaturaDto);

    UUID idAssinatura = assinaturaRepository.save(novaAssinatura).getId();

    return new ResponseSuccessBuilder<AssinaturaResponseDto>(HttpStatus.CREATED,
        new AssinaturaResponseDto(idAssinatura.toString()), "Assinatura criada com sucesso!").get();
  }
}
