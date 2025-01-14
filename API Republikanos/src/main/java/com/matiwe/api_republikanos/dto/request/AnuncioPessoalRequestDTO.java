package com.matiwe.api_republikanos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class AnuncioPessoalRequestDTO {
    private String profissao;

    private String gostos;

    private String habitos;

    private String habilidades;

    private int idade;

    private String bairroInteresse;

    private double valorLimite;

    private ContatoRequestDTO contatoDTO;
}
