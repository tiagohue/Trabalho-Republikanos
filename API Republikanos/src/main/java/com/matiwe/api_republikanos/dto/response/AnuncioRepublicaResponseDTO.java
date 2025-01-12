package com.matiwe.api_republikanos.dto.response;

import com.matiwe.api_republikanos.model.*;
import com.matiwe.api_republikanos.model.enums.Comodo;
import com.matiwe.api_republikanos.model.enums.Servico;
import com.matiwe.api_republikanos.model.enums.Vaga;
import lombok.Getter;

import java.util.List;

@Getter
public class AnuncioRepublicaResponseDTO {
    private Long id;

    private double valor;

    private String descricao;

    private List<Comodo> comodos;

    private List<Servico> servicos;

    private List<Vaga> vagas;

    private Localizacao localizacao;

    private Contato contato;

    public AnuncioRepublicaResponseDTO(AnuncioRepublica anuncioRepublica) {
        this.id = anuncioRepublica.getId();
        this.valor = anuncioRepublica.getValor();
        this.descricao = anuncioRepublica.getDescricao();
        this.comodos = anuncioRepublica.getComodos();
        this.servicos = anuncioRepublica.getServicos();
        this.vagas = anuncioRepublica.getVagas();
        this.localizacao = anuncioRepublica.getLocalizacao();
        this.contato = anuncioRepublica.getContato();
    }
}
