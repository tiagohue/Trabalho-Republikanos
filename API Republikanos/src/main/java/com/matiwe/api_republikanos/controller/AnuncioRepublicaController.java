package com.matiwe.api_republikanos.controller;

import com.matiwe.api_republikanos.dto.request.AnuncioRepublicaRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioRepublicaResponseDTO;
import com.matiwe.api_republikanos.repository.AnuncioRepublicaRepository;
import com.matiwe.api_republikanos.service.AnuncioRepublicaService;
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
@RequestMapping("/api/anunciosRepublicas")
@RequiredArgsConstructor
public class AnuncioRepublicaController {
    private final AnuncioRepublicaService anuncioRepublicaService;

    @Operation(summary = "Realiza uma busca de anúncios de repúblicas por Id ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não existe anuncio de republica com o Id informado"),

    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<AnuncioRepublicaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioRepublicaService.findById(id));
    }

    @Operation(summary = "Realiza uma busca de todos os anúncios de repúblicas ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nenhum anuncio cadastrado"),
    })
    @GetMapping
    public ResponseEntity<List<AnuncioRepublicaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(anuncioRepublicaService.findAll());
    }

    @Operation(summary = "Realiza o registro de um anúncio ", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anuncio da república registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "informações inválidas para o registro"),

    })
    @PostMapping
    public ResponseEntity<AnuncioRepublicaResponseDTO> register(
            @RequestBody AnuncioRepublicaRequestDTO anuncioRepublicaRequestDTO,
            UriComponentsBuilder uriBuilder) {

        AnuncioRepublicaResponseDTO anuncioRepublicaResponseDTO = anuncioRepublicaService.register(anuncioRepublicaRequestDTO);
        URI uri = uriBuilder.path("/anuncioRepublicas/{id}").buildAndExpand(anuncioRepublicaResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(anuncioRepublicaResponseDTO);
    }

    @Operation(summary = "Atualiza um anúncio ", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anúncio atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não existe anúncio de república com o Id informado"),

    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<AnuncioRepublicaResponseDTO> update(@RequestBody AnuncioRepublicaRequestDTO anuncioRepublicaDTO,
                                                      @PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioRepublicaService.update(anuncioRepublicaDTO, id));
    }

    @Operation(summary = "Deleta um anúncio ", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anúncio deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não existe anúncio de república com o Id informado"),

    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioRepublicaService.delete(id));
    }
}
