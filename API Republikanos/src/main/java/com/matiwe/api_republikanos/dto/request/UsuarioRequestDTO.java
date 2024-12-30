package com.matiwe.api_republikanos.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class UsuarioRequestDTO {
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;
}
