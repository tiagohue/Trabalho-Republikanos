package com.matiwe.api_republikanos.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LocalizacaoRequestDTO {
    private String logradouro;

    private String numero;

    private String bairro;
}
