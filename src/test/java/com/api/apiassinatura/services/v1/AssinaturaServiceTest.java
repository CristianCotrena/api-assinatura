package com.api.apiassinatura.services.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.api.apiassinatura.base.dtos.BaseDto;
import com.api.apiassinatura.entities.dtos.AssinaturaRequestDto;
import com.api.apiassinatura.entities.dtos.AssinaturaResponseDto;
import com.api.apiassinatura.entities.models.AssinaturaModel;
import com.api.apiassinatura.repositories.AssinaturaRepository;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@DisplayName("AssinaturaService - Testes")
class AssinaturaServiceTest {

  @MockBean
  private AssinaturaRepository assinaturaRepository;

  @Autowired
  private AssinaturaService assinaturaService;
  private AssinaturaRequestDto dtoAssinatura;
  private AssinaturaModel assinatura;

  @BeforeEach
  public void setUp() {
    assinaturaRepository = mock(AssinaturaRepository.class);
    assinaturaService = new AssinaturaService(assinaturaRepository);

    dtoAssinatura = new AssinaturaRequestDto();
    dtoAssinatura.setIdCliente(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
    dtoAssinatura.setIdPlano(UUID.fromString("432a4567-e89b-12d3-a456-426614174000"));
    dtoAssinatura.setStatus(1);

    AssinaturaModel assinatura = new AssinaturaModel();
  }

  @Test
  @DisplayName("01 - Service - Criar assinatura válida")
  public void testarCriarAssinaturaValida() {
    UUID validUUID = UUID.randomUUID();

    AssinaturaModel assinatura = new AssinaturaModel();
    assinatura.setId(validUUID);

    when(assinaturaRepository.findByIdCliente(any(UUID.class))).thenReturn(Optional.empty());
    assinatura.setIdCliente(validUUID);
    when(assinaturaRepository.save(any(AssinaturaModel.class))).thenReturn(assinatura);

    when(assinaturaRepository.findByIdPlano(any(UUID.class))).thenReturn(Optional.empty());
    assinatura.setIdPlano(validUUID);
    when(assinaturaRepository.save(any(AssinaturaModel.class))).thenReturn(assinatura);

    BaseDto<AssinaturaResponseDto> responseEntity = (BaseDto<AssinaturaResponseDto>)
        assinaturaService.criarAssinatura(dtoAssinatura).getBody();

    assertEquals(HttpStatus.CREATED.value(), responseEntity.getResultado().getStatus());
    assertEquals("Assinatura criada com sucesso!", responseEntity.getResultado().getDescricao());
  }

  @Test
  @DisplayName("02 - Service - Criar assinatura com CLIENTE já cadastrado")
  public void testarCriarAssinaturaClienteJaCadastrado() {
    UUID validUUID = UUID.randomUUID();

    AssinaturaModel assinatura = new AssinaturaModel();
    assinatura.setId(validUUID);

    when(assinaturaRepository.findByIdCliente(any(UUID.class))).thenReturn(
        Optional.of(assinatura));
    when(assinaturaRepository.save(any(AssinaturaModel.class))).thenReturn(assinatura);

    BaseDto<AssinaturaResponseDto> responseEntity = (BaseDto<AssinaturaResponseDto>)
        assinaturaService.criarAssinatura(dtoAssinatura).getBody();

    assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getResultado().getStatus());
    assertEquals("Cliente já cadastrado na assinatura!",
        responseEntity.getResultado().getDescricao());
  }

  @Test
  @DisplayName("03 - Service - Criar assinatura com CLIENTE inválido")
  public void testarCriarAssinaturaClienteInvalido() {
    dtoAssinatura.setIdCliente(null);

    when(assinaturaRepository.findByIdCliente(any(UUID.class))).thenReturn(Optional.empty());
    when(assinaturaRepository.save(any(AssinaturaModel.class))).thenReturn(assinatura);

    BaseDto<AssinaturaResponseDto> responseEntity = (BaseDto<AssinaturaResponseDto>)
        assinaturaService.criarAssinatura(dtoAssinatura).getBody();

    assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getResultado().getStatus());
    assertEquals("Bad Request",
        responseEntity.getResultado().getDescricao());
  }

  @Test
  @DisplayName("04 - Service - Criar assinatura com PLANO inválido")
  public void testarCriarAssinaturaPlanoInvalido(){
    dtoAssinatura.setIdPlano(null);

    when(assinaturaRepository.findByIdPlano(any(UUID.class))).thenReturn(Optional.empty());
    when(assinaturaRepository.save(any(AssinaturaModel.class))).thenReturn(assinatura);

    BaseDto<AssinaturaResponseDto> responseEntity = (BaseDto<AssinaturaResponseDto>)
        assinaturaService.criarAssinatura(dtoAssinatura).getBody();

    assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getResultado().getStatus());
    assertEquals("Bad Request",
        responseEntity.getResultado().getDescricao());
  }
}