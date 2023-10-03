package com.api.apiassinatura.services.v1;

import com.api.apiassinatura.base.dtos.BaseErrorDto;
import com.api.apiassinatura.builders.ResponseErrorBuilder;
import com.api.apiassinatura.builders.ResponseSuccessBuilder;
import com.api.apiassinatura.entities.dtos.AssinaturaCriarDto;
import com.api.apiassinatura.entities.dtos.AssinaturaDto;
import com.api.apiassinatura.entities.models.AssinaturaModel;
import com.api.apiassinatura.repositories.AssinaturaRepository;
import com.api.apiassinatura.validations.CriarAssinaturaValidate;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaService {

  private AssinaturaRepository assinaturaRepository;

  @Autowired
  public ResponseEntity criarAssinatura() {
    return null;
  }

  @Transactional
  public ResponseEntity criarAssinatura(AssinaturaCriarDto novaAssinaturaDto) {
    List<BaseErrorDto> erros = new CriarAssinaturaValidate().validar(novaAssinaturaDto);

    if (erros.size() > 0) {
      return new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, erros).get();
    }

    if (assinaturaRepository.findByIdCliente(novaAssinaturaDto.getIdCliente()).isPresent()) {
      return new ResponseErrorBuilder(
          HttpStatus.BAD_REQUEST,
          "Cliente já cadastrado na assinatura!"
      ).get();
    }

    AssinaturaModel novaAssinatura = new AssinaturaModel();

    novaAssinatura.setIdCliente(novaAssinaturaDto.getIdCliente());
    novaAssinatura.setIdPlano(novaAssinaturaDto.getIdPlano());
    novaAssinatura.setStatus(1);

    UUID idAssinatura = assinaturaRepository.save(novaAssinatura).getId();

    return new ResponseSuccessBuilder<AssinaturaDto>(
        HttpStatus.CREATED,
        new AssinaturaDto(idAssinatura.toString()),
        "Assinatura criada com sucesso!"
    ).get();
  }

}
