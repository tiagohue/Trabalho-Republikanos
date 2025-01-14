package com.matiwe.api_republikanos.dto.request;

import com.matiwe.api_republikanos.model.Localizacao;
import com.matiwe.api_republikanos.model.enums.Comodo;
import com.matiwe.api_republikanos.model.enums.Servico;
import com.matiwe.api_republikanos.model.enums.Vaga;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter @Setter
public class AnuncioRepublicaRequestDTO {
    private double valor;

    private String Descricao;

    private List<Comodo> comodos;

    private List<Servico> servicos;
    
    @NotEmpty(message = "Deve haver pelo menos uma vaga disponível")
    private List<Vaga> vagas;

    @NotNull(message = "A localização é obrigatória")
    @Valid
    private LocalizacaoRequestDTO localizacaoDTO;

    @NotNull(message = "Deve ser informado pelo menos um contato")
    @Valid
    private ContatoRequestDTO contatoDTO;
}
