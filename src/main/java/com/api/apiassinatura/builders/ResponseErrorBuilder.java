package com.api.apiassinatura.builders;

import com.api.apiassinatura.base.dtos.BaseDto;
import com.api.apiassinatura.base.dtos.BaseErrorDto;
import com.api.apiassinatura.base.dtos.BaseResultDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseErrorBuilder {

  private ResponseEntity<BaseDto<Void>> resultado;

  public ResponseErrorBuilder(HttpStatus status, String mensagem) {
    BaseResultDto resultado = new BaseResultDto(status.value(), mensagem);
    BaseDto<Void> baseDto = new BaseDto<>(null, new ArrayList<>(), resultado);
    this.resultado = ResponseEntity.status(status.value()).body(baseDto);
  }

  public ResponseErrorBuilder(HttpStatus status, List<BaseErrorDto> erros) {
    BaseResultDto resultado = new BaseResultDto(status.value(), status.getReasonPhrase());
    BaseDto<Void> baseDto = new BaseDto<>(null, erros, resultado);
    this.resultado = ResponseEntity.status(status.value()).body(baseDto);
  }

  public ResponseErrorBuilder(HttpStatus status, String mensagem, List<BaseErrorDto> erros) {
    BaseResultDto resultado = new BaseResultDto(status.value(), mensagem);
    BaseDto<Void> baseDto = new BaseDto<>(null, erros, resultado);
    this.resultado = ResponseEntity.status(status.value()).body(baseDto);
  }

  public ResponseEntity<BaseDto<Void>> get() {
    return resultado;
  }
}