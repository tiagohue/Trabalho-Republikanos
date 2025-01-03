package com.matiwe.api_republikanos.dto.response;

import com.matiwe.api_republikanos.model.Localizacao;
import lombok.Getter;

@Getter
public class LocalizacaoResponseDTO {
    private Long id;

    private String logradouro;

    private String numero;

    private String bairro;

    public LocalizacaoResponseDTO(Localizacao localizacao) {
        this.id = localizacao.getId();
        this.logradouro = localizacao.getLogradouro();
        this.numero = localizacao.getNumero();
        this.bairro = localizacao.getBairro();
    }
}
