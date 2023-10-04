package com.api.apiassinatura.transform;

import com.api.apiassinatura.entities.dtos.AssinaturaRequestDto;
import com.api.apiassinatura.entities.models.AssinaturaModel;

public class AssinaturaModelTransform {

  public AssinaturaModel transformarAssinaturaModel(AssinaturaRequestDto assinaturaRequestDto) {
    AssinaturaModel assinaturaModel = new AssinaturaModel();

    assinaturaModel.setIdCliente(assinaturaRequestDto.getIdCliente());
    assinaturaModel.setIdPlano(assinaturaRequestDto.getIdPlano());
    assinaturaModel.setStatus(1);

    if (assinaturaRequestDto.getStatus() == null) {
      assinaturaModel.setStatus(1);
    } else {
      assinaturaModel.setStatus(assinaturaRequestDto.getStatus());
    }

    return assinaturaModel;
  }
}
