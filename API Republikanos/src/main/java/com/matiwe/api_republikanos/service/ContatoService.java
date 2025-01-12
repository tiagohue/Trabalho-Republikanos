package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.ContatoRequestDTO;
import com.matiwe.api_republikanos.dto.response.ContatoResponseDTO;
import com.matiwe.api_republikanos.model.Contato;

import java.util.List;

public interface ContatoService {
    ContatoResponseDTO findById(Long id);

    List<ContatoResponseDTO> findAll();

    ContatoResponseDTO register(ContatoRequestDTO contatoDTO);

    ContatoResponseDTO update(ContatoRequestDTO contatoDTO, Long id);

    String delete(Long id);

    Contato registerByAnuncio(ContatoRequestDTO contatoDTO);
}
