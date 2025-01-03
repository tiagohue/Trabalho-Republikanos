package com.matiwe.api_republikanos.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioRequestDTO {
    private String login;

    private String senha;

    private String nome;
}
