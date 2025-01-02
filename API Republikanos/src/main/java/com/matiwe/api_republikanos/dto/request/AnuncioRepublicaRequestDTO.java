package com.matiwe.api_republikanos.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AnuncioRepublicaRequestDTO {
    @Column(nullable = false)
    private double valor;

    private String Descricao;
}
