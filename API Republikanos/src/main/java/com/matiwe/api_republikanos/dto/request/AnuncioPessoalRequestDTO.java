package com.matiwe.api_republikanos.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "O bairro de interesse é obrigatório")
    private String bairroInteresse;

    @DecimalMin(value = "100.0", inclusive = true, message = "O valor limite deve ser maior ou igual a 100")
    private double valorLimite;

    @NotNull(message = "As informações de contato são obrigatórias")
    private ContatoRequestDTO contatoDTO;
}
