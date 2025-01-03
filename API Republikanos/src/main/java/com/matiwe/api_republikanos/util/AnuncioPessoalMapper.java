package com.matiwe.api_republikanos.util;

import com.matiwe.api_republikanos.dto.request.AnuncioPessoalRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioPessoalResponseDTO;
import com.matiwe.api_republikanos.model.AnuncioPessoal;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnuncioPessoalMapper {
    public AnuncioPessoal toAnuncioPessoal(AnuncioPessoalRequestDTO anuncioPessoalDTO) {
        return AnuncioPessoal.builder()
                .profissao(anuncioPessoalDTO.getProfissao())
                .gostos(anuncioPessoalDTO.getGostos())
                .habitos(anuncioPessoalDTO.getHabitos())
                .habilidades(anuncioPessoalDTO.getHabilidades())
                .idade(anuncioPessoalDTO.getIdade())
                .bairro_interesse(anuncioPessoalDTO.getBairro_interesse())
                .valor_limite(anuncioPessoalDTO.getValor_limite())
                .build();
    }

    public AnuncioPessoalResponseDTO toAnuncioPessoalDTO(AnuncioPessoal anuncioPessoal) {
        return new AnuncioPessoalResponseDTO(anuncioPessoal);
    }

    public List<AnuncioPessoalResponseDTO> toAnuncioPessoalDTO(List<AnuncioPessoal> anuncioPessoalList) {
        return anuncioPessoalList.stream().map(AnuncioPessoalResponseDTO::new).collect(Collectors.toList());
    }

    public void updateAnuncioPessoal(AnuncioPessoal anuncioPessoal, AnuncioPessoalRequestDTO anuncioPessoalDTO) {
        anuncioPessoal.setProfissao(anuncioPessoalDTO.getProfissao());
        anuncioPessoal.setGostos(anuncioPessoalDTO.getGostos());
        anuncioPessoal.setHabitos(anuncioPessoalDTO.getHabitos());
        anuncioPessoal.setHabilidades(anuncioPessoalDTO.getHabilidades());
        anuncioPessoal.setIdade(anuncioPessoalDTO.getIdade());
        anuncioPessoal.setBairro_interesse(anuncioPessoalDTO.getBairro_interesse());
        anuncioPessoal.setValor_limite(anuncioPessoalDTO.getValor_limite());
    }
}
