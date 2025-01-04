package com.matiwe.api_republikanos.util;

import com.matiwe.api_republikanos.dto.request.ContatoRequestDTO;
import com.matiwe.api_republikanos.dto.response.ContatoResponseDTO;
import com.matiwe.api_republikanos.model.Contato;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContatoMapper {
    public Contato toContato(ContatoRequestDTO contatoDTO) {
        return Contato.builder()
                .telefone(contatoDTO.getTelefone())
                .email(contatoDTO.getEmail())
                .build();
    }

    public ContatoResponseDTO toContatoDTO(Contato contato) {
        return new ContatoResponseDTO(contato);
    }

    public List<ContatoResponseDTO> toContatoDTO(List<Contato> contatoList) {
        return contatoList.stream().map(ContatoResponseDTO::new).collect(Collectors.toList());
    }

    public void updateContato(Contato contato, ContatoRequestDTO contatoDTO) {
        contato.setTelefone(contatoDTO.getTelefone());
        contato.setEmail(contatoDTO.getEmail());
    }
}
