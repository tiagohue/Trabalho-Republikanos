package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.UsuarioRequestDTO;
import com.matiwe.api_republikanos.dto.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO findById(Long id);

    List<UsuarioResponseDTO> findAll();

    UsuarioResponseDTO register(UsuarioRequestDTO usuarioDTO);

    UsuarioResponseDTO update(UsuarioRequestDTO usuarioDTO, Long id);

    String delete(Long id);
}
