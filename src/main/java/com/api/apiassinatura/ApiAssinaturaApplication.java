package com.api.apiassinatura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiAssinaturaApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiAssinaturaApplication.class, args);
  }

  @GetMapping("/")
  public String teste() {
    return "Hello World!!!!";
  }
}
