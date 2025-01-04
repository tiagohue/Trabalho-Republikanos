package com.matiwe.api_republikanos.dto.request;

import com.matiwe.api_republikanos.model.Localizacao;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AnuncioRepublicaRequestDTO {
    private double valor;

    private String Descricao;

    private LocalizacaoRequestDTO localizacaoDTO;

    private ContatoRequestDTO contatoDTO;
}
