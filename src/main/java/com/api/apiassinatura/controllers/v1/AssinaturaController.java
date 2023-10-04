package com.api.apiassinatura.controllers.v1;

import com.api.apiassinatura.base.dtos.BaseDto;
import com.api.apiassinatura.entities.dtos.AssinaturaRequestDto;
import com.api.apiassinatura.services.v1.AssinaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/assinatura")
@Tag(
    name = "API Assinatura",
    description = "Microserviço assinatura para API Forma NT - Academia"
)
public class AssinaturaController {

  private AssinaturaService assinaturaService;

  public AssinaturaController(AssinaturaService assinaturaService) {
    this.assinaturaService = assinaturaService;
  }

  @Operation(
      summary = "Criar assinatura",
      description = "Cria uma nova assinatura",
      method = "POST"
  )
  @ApiResponse(
      responseCode = "201",
      description = "Assinatura criada com sucesso"

  )
  @ApiResponse(
      responseCode = "400",
      description = "Erro de validação"
  )
  @ApiResponse(
      responseCode = "500",
      description = "Erro interno"
  )
  @PostMapping
  public ResponseEntity<BaseDto> criarAssinatura(
      @RequestBody AssinaturaRequestDto novaAssinaturaDto
  ) {
    return assinaturaService.criarAssinatura(novaAssinaturaDto);
  }

}
