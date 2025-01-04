package com.matiwe.api_republikanos.dto.response;

import com.matiwe.api_republikanos.model.Contato;
import lombok.Getter;

@Getter
public class ContatoResponseDTO {
    private Long id;

    private String telefone;

    private String email;

    public ContatoResponseDTO(Contato contato) {
        this.id = contato.getId();
        this.telefone = contato.getTelefone();
        this.email = contato.getEmail();
    }
}
