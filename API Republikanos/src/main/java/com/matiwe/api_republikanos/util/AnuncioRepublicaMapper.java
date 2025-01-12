package com.matiwe.api_republikanos.util;

import com.matiwe.api_republikanos.dto.request.AnuncioRepublicaRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioRepublicaResponseDTO;
import com.matiwe.api_republikanos.model.AnuncioRepublica;
import com.matiwe.api_republikanos.service.LocalizacaoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnuncioRepublicaMapper {
    private final LocalizacaoService localizacaoService;

    public AnuncioRepublicaMapper(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    public AnuncioRepublica toAnuncioRepublica(AnuncioRepublicaRequestDTO anuncioRepublicaDTO) {
        return AnuncioRepublica.builder()
                .valor(anuncioRepublicaDTO.getValor())
                .descricao(anuncioRepublicaDTO.getDescricao())
                .comodos(anuncioRepublicaDTO.getComodos())
                .servicos(anuncioRepublicaDTO.getServicos())
                .vagas(anuncioRepublicaDTO.getVagas())
                .build();
    }

    public AnuncioRepublicaResponseDTO toAnuncioRepublicaDTO(AnuncioRepublica anuncioRepublica) {
        return new AnuncioRepublicaResponseDTO(anuncioRepublica);
    }

    public List<AnuncioRepublicaResponseDTO> toAnuncioRepublicaDTO(List<AnuncioRepublica> anuncioRepublicaList) {
        return anuncioRepublicaList.stream().map(AnuncioRepublicaResponseDTO::new).collect(Collectors.toList());
    }

    public void updateAnuncioRepublica(AnuncioRepublica anuncioRepublica, AnuncioRepublicaRequestDTO anuncioRepublicaDTO) {
        anuncioRepublica.setValor(anuncioRepublicaDTO.getValor());
        anuncioRepublica.setDescricao(anuncioRepublicaDTO.getDescricao());
        anuncioRepublica.setComodos(anuncioRepublicaDTO.getComodos());
        anuncioRepublica.setServicos(anuncioRepublicaDTO.getServicos());
        anuncioRepublica.setVagas(anuncioRepublicaDTO.getVagas());
    }
}
