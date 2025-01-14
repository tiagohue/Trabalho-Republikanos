package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.UsuarioRequestDTO;
import com.matiwe.api_republikanos.dto.response.UsuarioResponseDTO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO findById(String id);

    List<UsuarioResponseDTO> findAll();

    UsuarioResponseDTO register(UsuarioRequestDTO usuarioDTO);

    UsuarioResponseDTO update(UsuarioRequestDTO usuarioDTO, String id);

    String delete(String id);
}
