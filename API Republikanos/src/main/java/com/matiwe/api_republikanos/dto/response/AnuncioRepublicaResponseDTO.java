package com.matiwe.api_republikanos.dto.response;

import com.matiwe.api_republikanos.model.*;
import com.matiwe.api_republikanos.model.enums.Comodo;
import com.matiwe.api_republikanos.model.enums.Servico;
import com.matiwe.api_republikanos.model.enums.Vaga;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class AnuncioRepublicaResponseDTO {
    private Long id;

    @Column(nullable = false)
    private double valor;

    @Column
    private String descricao;

    @ElementCollection()
    private List<Comodo> comodos;

    @ElementCollection
    private List<Servico> servicos;

    @ManyToOne
    private Localizacao localizacao;

    @ElementCollection
    private List<Vaga> vagas;

    @ManyToOne
    private Contato contato;

    public AnuncioRepublicaResponseDTO(AnuncioRepublica anuncioRepublica) {
        this.id = anuncioRepublica.getId();
        this.valor = anuncioRepublica.getValor();
        this.descricao = anuncioRepublica.getDescricao();
        this.comodos = anuncioRepublica.getComodos();
        this.servicos = anuncioRepublica.getServicos();
        this.localizacao = anuncioRepublica.getLocalizacao();
        this.vagas = anuncioRepublica.getVagas();
        this.contato = anuncioRepublica.getContato();
    }
}
