package com.matiwe.api_republikanos.controller;

import com.matiwe.api_republikanos.dto.request.UsuarioRequestDTO;
import com.matiwe.api_republikanos.dto.response.UsuarioResponseDTO;
import com.matiwe.api_republikanos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> register(
            @RequestBody UsuarioRequestDTO usuarioRequestDTO,
            UriComponentsBuilder uriBuilder) {

        UsuarioResponseDTO usuarioResponseDTO = usuarioService.register(usuarioRequestDTO);
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuarioResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(usuarioResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@RequestBody UsuarioRequestDTO usuarioDTO,
                                                      @PathVariable String id) {
        return ResponseEntity.ok().body(usuarioService.update(usuarioDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return ResponseEntity.ok().body(usuarioService.delete(id));
    }
}
