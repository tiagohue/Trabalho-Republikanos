package com.matiwe.api_republikanos.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ContatoRequestDTO {
    private String telefone;

    private String email;
}
