package com.api.apiassinatura.validations;

import com.api.apiassinatura.base.dtos.BaseErrorDto;
import com.api.apiassinatura.constants.MensagensErros;
import com.api.apiassinatura.entities.dtos.AssinaturaCriarDto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CriarAssinaturaValidate {

  public List<BaseErrorDto> validar(AssinaturaCriarDto assinaturaCriarDto) {
    List<BaseErrorDto> erros = validarCamposRequeridos(assinaturaCriarDto);
    return erros.size() > 0 ? erros : validarCamposInvalidos(assinaturaCriarDto, erros);
  }

  private List<BaseErrorDto> validarCamposRequeridos(AssinaturaCriarDto assinaturaCriarDto) {
    List<BaseErrorDto> erros = new ArrayList<>();

    // Campos obrigatórios
    if (assinaturaCriarDto.getIdPlano() == null) {
      erros.add(new BaseErrorDto("idPlano", MensagensErros.EMPTY_FIELD));
    }

    if (assinaturaCriarDto.getIdCliente() == null) {
      erros.add(new BaseErrorDto("idCliente", MensagensErros.EMPTY_FIELD));
    }


    return erros;
  }

  private List<BaseErrorDto> validarCamposInvalidos(AssinaturaCriarDto assinaturaCriarDto,
      List<BaseErrorDto> erros) {

    // Ids devem ser UUIDs
    if (assinaturaCriarDto.getIdCliente() == UUID.randomUUID()) {
      erros.add(new BaseErrorDto("idCliente", MensagensErros.INVALID_FIELD));
    }

    if (assinaturaCriarDto.getIdPlano() == UUID.randomUUID()) {
      erros.add(new BaseErrorDto("idPlano", MensagensErros.INVALID_FIELD));
    }

    return erros;
  }
}
