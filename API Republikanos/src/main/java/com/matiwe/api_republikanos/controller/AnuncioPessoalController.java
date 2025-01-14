package com.matiwe.api_republikanos.controller;

import com.matiwe.api_republikanos.dto.request.AnuncioPessoalRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioPessoalResponseDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioRepublicaResponseDTO;
import com.matiwe.api_republikanos.service.AnuncioPessoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/anunciosPessoais")
@RequiredArgsConstructor
public class AnuncioPessoalController {
    private final AnuncioPessoalService anuncioPessoalService;

    @Operation(summary = "Realiza uma busca de anúncios de pessoais por Id ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não existe anuncio com o Id informado"),

    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<AnuncioPessoalResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioPessoalService.findById(id));
    }

    @Operation(summary = "Realiza uma busca de todos os anúncios pessoais ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nenhum anuncio cadastrado"),
    })
    @GetMapping
    public ResponseEntity<List<AnuncioPessoalResponseDTO>> findAll() {
        return ResponseEntity.ok().body(anuncioPessoalService.findAll());
    }

    @Operation(summary = "Realiza o registro de um anúncio ", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Anuncio pessoal registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "informações inválidas para o registro"),

    })
    @PostMapping
    public ResponseEntity<AnuncioPessoalResponseDTO> register(
            @RequestBody @Valid AnuncioPessoalRequestDTO anuncioPessoalRequestDTO,
            UriComponentsBuilder uriBuilder) {

        AnuncioPessoalResponseDTO anuncioPessoalResponseDTO = anuncioPessoalService.register(anuncioPessoalRequestDTO);
        URI uri = uriBuilder.path("/anuncioPessoals/{id}").buildAndExpand(anuncioPessoalResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(anuncioPessoalResponseDTO);
    }

    @Operation(summary = "Atualiza um anúncio ", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anúncio atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não existe anúncio pessoal com o Id informado"),

    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<AnuncioPessoalResponseDTO> update(@RequestBody AnuncioPessoalRequestDTO anuncioPessoalDTO,
                                                      @PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioPessoalService.update(anuncioPessoalDTO, id));
    }

    @Operation(summary = "Deleta um anúncio ", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anúncio deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Não existe anúncio pessoal com o Id informado"),

    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioPessoalService.delete(id));
    }

    @Operation(summary = "Realiza uma busca de anúncios pessoais por bairro de interesse ", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nenhum anuncio cadastrado com esse bairo"),
    })
    @PostMapping(value = "/buscar")
    public ResponseEntity<List<AnuncioPessoalResponseDTO>> buscarPeloBairro(@Param("bairro") String bairro) {
        return ResponseEntity.ok().body(anuncioPessoalService.findByBairro(bairro));
    }
}
