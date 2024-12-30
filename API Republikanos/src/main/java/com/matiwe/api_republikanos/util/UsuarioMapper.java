package com.matiwe.api_republikanos.util;

import com.matiwe.api_republikanos.dto.request.UsuarioRequestDTO;
import com.matiwe.api_republikanos.dto.response.UsuarioResponseDTO;
import com.matiwe.api_republikanos.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    public Usuario toUsuario(UsuarioRequestDTO usuarioDTO) {
        return Usuario.builder()
                .login(usuarioDTO.getLogin())
                .senha(usuarioDTO.getSenha())
                .nome(usuarioDTO.getNome())
                .build();
    }

    public UsuarioResponseDTO toUsuarioDTO(Usuario usuario) {
        return new UsuarioResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> toUsuarioDTO(List<Usuario> usuarioList) {
        return usuarioList.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    public void updateUsuario(Usuario usuario, UsuarioRequestDTO usuarioDTO) {
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setNome(usuarioDTO.getNome());
    }
}
