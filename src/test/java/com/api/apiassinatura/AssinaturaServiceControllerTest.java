package com.api.apiassinatura;

import static org.junit.jupiter.api.Assertions.fail;

import com.api.apiassinatura.services.v1.AssinaturaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@DisplayName("AssinaturaServiceController - Testes")
public class AssinaturaServiceControllerTest {

  @Autowired
  ApplicationContext context;

  @Test
  @DisplayName("01 - Classe da camada SERVICE criada corretamente")
  void testaClasseServiceExiste() {
    try {
      context.getBean(AssinaturaService.class);
    } catch (NoSuchBeanDefinitionException exc) {
      fail("Classe da camada serviço deve existir e ser implementada de forma correta");
    }
  }

  @Test
  @DisplayName("02 - Classe da camada CONTROLLER criada corretamente")
  void testaClasseControllerExiste() {
    try {
      context.getBean(AssinaturaService.class);
    } catch (NoSuchBeanDefinitionException exc) {
      fail("Classe da camada controle deve existir e ser implementada de forma correta");
    }
  }
}
