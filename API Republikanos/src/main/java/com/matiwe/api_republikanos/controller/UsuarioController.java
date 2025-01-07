package com.matiwe.api_republikanos.controller;

import com.matiwe.api_republikanos.dto.request.UsuarioRequestDTO;
import com.matiwe.api_republikanos.dto.response.UsuarioResponseDTO;
import com.matiwe.api_republikanos.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Realiza uma busca de usuários por Id ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não existe usuario com o Id informado"),

    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @Operation(summary = "Realiza uma busca de todos os usuários ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nenhum usuario cadastrado"),
    })
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @Operation(summary = "Realiza o registro de um usuário ", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "informações inválidas para o registro"),

    })
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> register(
            @RequestBody UsuarioRequestDTO usuarioRequestDTO,
            UriComponentsBuilder uriBuilder) {

        UsuarioResponseDTO usuarioResponseDTO = usuarioService.register(usuarioRequestDTO);
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuarioResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(usuarioResponseDTO);
    }

    @Operation(summary = "Atualiza um usuário ", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não existe usuario com o Id informado"),

    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@RequestBody UsuarioRequestDTO usuarioDTO,
                                                      @PathVariable String id) {
        return ResponseEntity.ok().body(usuarioService.update(usuarioDTO, id));
    }

    @Operation(summary = "Deleta um usuario ", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não existe usuario com o Id informado"),

    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return ResponseEntity.ok().body(usuarioService.delete(id));
    }
}
