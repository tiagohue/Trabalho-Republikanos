package com.matiwe.api_republikanos.util;

import com.matiwe.api_republikanos.dto.request.LocalizacaoRequestDTO;
import com.matiwe.api_republikanos.dto.response.LocalizacaoResponseDTO;
import com.matiwe.api_republikanos.model.Localizacao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocalizacaoMapper {
    public Localizacao toLocalizacao(LocalizacaoRequestDTO localizacaoDTO) {
        return Localizacao.builder()
                .logradouro(localizacaoDTO.getLogradouro())
                .numero(localizacaoDTO.getNumero())
                .bairro(localizacaoDTO.getBairro())
                .build();
    }

    public LocalizacaoResponseDTO toLocalizacaoDTO(Localizacao localizacao) {
        return new LocalizacaoResponseDTO(localizacao);
    }

    public List<LocalizacaoResponseDTO> toLocalizacaoDTO(List<Localizacao> localizacaoList) {
        return localizacaoList.stream().map(LocalizacaoResponseDTO::new).collect(Collectors.toList());
    }

    public void updateLocalizacao(Localizacao localizacao, LocalizacaoRequestDTO localizacaoDTO) {
        localizacao.setLogradouro(localizacaoDTO.getLogradouro());
        localizacao.setNumero(localizacaoDTO.getNumero());
        localizacao.setBairro(localizacaoDTO.getBairro());
    }
}
