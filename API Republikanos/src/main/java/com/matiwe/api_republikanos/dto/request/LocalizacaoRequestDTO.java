package com.matiwe.api_republikanos.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class LocalizacaoRequestDTO {
    private String logradouro;

    private String numero;

    private String bairro;
}
