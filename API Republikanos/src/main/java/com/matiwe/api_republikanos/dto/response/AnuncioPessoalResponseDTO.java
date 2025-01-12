package com.matiwe.api_republikanos.dto.response;

import com.matiwe.api_republikanos.model.AnuncioPessoal;
import com.matiwe.api_republikanos.model.Contato;
import lombok.Getter;

@Getter
public class AnuncioPessoalResponseDTO {
    private Long id;

    private String profissao;

    private String gostos;

    private String habitos;

    private String habilidades;

    private int idade;

    private String bairroInteresse;

    private double valorLimite;

    private Contato contato;

    public AnuncioPessoalResponseDTO(AnuncioPessoal anuncioPessoal) {
        this.id = anuncioPessoal.getId();
        this.profissao = anuncioPessoal.getProfissao();
        this.gostos = anuncioPessoal.getGostos();
        this.habitos = anuncioPessoal.getHabitos();
        this.habilidades = anuncioPessoal.getHabilidades();
        this.idade = anuncioPessoal.getIdade();
        this.bairroInteresse = anuncioPessoal.getBairroInteresse();
        this.valorLimite = anuncioPessoal.getValorLimite();
        this.contato = anuncioPessoal.getContato();
    }
}
