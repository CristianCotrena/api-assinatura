package com.api.apiassinatura.entities.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("AssinaturaDto - Testes")
class AssinaturaCriarDtoTest {

  @Test
  @DisplayName("01 - DTO - Criação de AssinaturaDto e AssinaturaCriarDto")
  void testDtoClasses() {
    Map<String, Map<String, String>> expectedMap = Map.of(
        "com.api.apiassinatura.entities.dtos.AssinaturaDto", Map.of(
            "id", String.class.getName()
        ),
        "com.api.apiassinatura.entities.dtos.AssinaturaCriarDto", Map.of(
            "idCliente", UUID.class.getName(),
            "idPlano", UUID.class.getName(),
            "status", Integer.class.getName()
        )
    );
    try {
      for (String className : expectedMap.keySet()) {
        Class<?> classToTest = Class.forName(className);
        assertEquals(
            expectedMap.get(className),
            Arrays.stream(classToTest.getDeclaredFields())
                .filter(field -> !field.getName().equals("serialVersionUID"))
                .collect(Collectors.toMap(Field::getName, (f) -> f.getType().getName())),
            "Os atributos precisam estar definidos e com os tipos corretos para a classe "
                + className
        );
      }
    } catch (ClassNotFoundException e) {
      fail("As classes de DTO precisam existir: " + e.getMessage());
    }
  }
}
