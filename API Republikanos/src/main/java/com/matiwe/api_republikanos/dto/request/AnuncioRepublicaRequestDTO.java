package com.matiwe.api_republikanos.dto.request;

import com.matiwe.api_republikanos.model.Localizacao;
import com.matiwe.api_republikanos.model.enums.Comodo;
import com.matiwe.api_republikanos.model.enums.Servico;
import com.matiwe.api_republikanos.model.enums.Vaga;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AnuncioRepublicaRequestDTO {
    private double valor;

    private String Descricao;

    private List<Comodo> comodos;

    private List<Servico> servicos;

    private List<Vaga> vagas;

    private LocalizacaoRequestDTO localizacaoDTO;

    private ContatoRequestDTO contatoDTO;
}
