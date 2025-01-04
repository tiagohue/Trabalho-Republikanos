package com.matiwe.api_republikanos.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContatoRequestDTO {
    private String telefone;

    private String email;
}
