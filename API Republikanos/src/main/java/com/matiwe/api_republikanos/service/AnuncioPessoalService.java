package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.AnuncioPessoalRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioPessoalResponseDTO;

import java.util.List;

public interface AnuncioPessoalService {
    AnuncioPessoalResponseDTO findById(Long id);

    List<AnuncioPessoalResponseDTO> findAll();

    AnuncioPessoalResponseDTO register(AnuncioPessoalRequestDTO anuncioPessoalDTO);

    AnuncioPessoalResponseDTO update(AnuncioPessoalRequestDTO anuncioPessoalDTO, Long id);

    String delete(Long id);

    List<AnuncioPessoalResponseDTO> findByBairro(String bairro);
}
