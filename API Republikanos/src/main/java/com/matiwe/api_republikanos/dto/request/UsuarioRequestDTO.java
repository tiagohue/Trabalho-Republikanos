package com.matiwe.api_republikanos.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioRequestDTO {
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;
}
