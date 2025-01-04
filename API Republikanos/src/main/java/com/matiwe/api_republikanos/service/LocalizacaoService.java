package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.LocalizacaoRequestDTO;
import com.matiwe.api_republikanos.dto.response.LocalizacaoResponseDTO;

import java.util.List;

public interface LocalizacaoService {
    LocalizacaoResponseDTO findById(Long id);

    List<LocalizacaoResponseDTO> findAll();

    LocalizacaoResponseDTO register(LocalizacaoRequestDTO localizacaoDTO);

    LocalizacaoResponseDTO update(LocalizacaoRequestDTO localizacaoDTO, Long id);

    String delete(Long id);
}
