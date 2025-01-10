package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.AnuncioRepublicaRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioRepublicaResponseDTO;

import java.util.List;

public interface AnuncioRepublicaService {
    AnuncioRepublicaResponseDTO findById(Long id);

    List<AnuncioRepublicaResponseDTO> findAll();

    AnuncioRepublicaResponseDTO register(AnuncioRepublicaRequestDTO anuncioRepublicaDTO);

    AnuncioRepublicaResponseDTO update(AnuncioRepublicaRequestDTO anuncioRepublicaDTO, Long id);

    String delete(Long id);

    List<AnuncioRepublicaResponseDTO> findByBairro(String bairro);
}
