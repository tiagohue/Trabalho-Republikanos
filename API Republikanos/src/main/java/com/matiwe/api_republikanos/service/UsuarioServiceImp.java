package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.UsuarioRequestDTO;
import com.matiwe.api_republikanos.dto.response.UsuarioResponseDTO;
import com.matiwe.api_republikanos.model.Usuario;
import com.matiwe.api_republikanos.repository.UsuarioRepository;
import com.matiwe.api_republikanos.util.UsuarioMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class UsuarioServiceImp implements UsuarioService{
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDTO findById(Long id) {
        return usuarioMapper.toUsuarioDTO(returnUsuario(id));
    }

    @Override
    public List<UsuarioResponseDTO> findAll() {
        return usuarioMapper.toUsuarioDTO(usuarioRepository.findAll());
    }

    @Override @Transactional
    public UsuarioResponseDTO register(UsuarioRequestDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);

        return usuarioMapper.toUsuarioDTO(usuarioRepository.save(usuario));
    }

    @Override @Transactional
    public UsuarioResponseDTO update(UsuarioRequestDTO usuarioDTO, Long id) {
        Usuario usuario = returnUsuario(id);

        usuarioMapper.updateUsuario(usuario, usuarioDTO);

        return usuarioMapper.toUsuarioDTO(usuarioRepository.save(usuario));
    }

    @Override @Transactional
    public String delete(Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario de id: " + id + " foi deletado.";
    }

    private Usuario returnUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
    }
}
