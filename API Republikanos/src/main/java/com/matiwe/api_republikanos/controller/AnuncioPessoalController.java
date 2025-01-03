package com.matiwe.api_republikanos.controller;

import com.matiwe.api_republikanos.dto.request.AnuncioPessoalRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioPessoalResponseDTO;
import com.matiwe.api_republikanos.service.AnuncioPessoalService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnuncioPessoalResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioPessoalService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AnuncioPessoalResponseDTO>> findAll() {
        return ResponseEntity.ok().body(anuncioPessoalService.findAll());
    }

    @PostMapping
    public ResponseEntity<AnuncioPessoalResponseDTO> register(
            @RequestBody AnuncioPessoalRequestDTO anuncioPessoalRequestDTO,
            UriComponentsBuilder uriBuilder) {

        AnuncioPessoalResponseDTO anuncioPessoalResponseDTO = anuncioPessoalService.register(anuncioPessoalRequestDTO);
        URI uri = uriBuilder.path("/anuncioPessoals/{id}").buildAndExpand(anuncioPessoalResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(anuncioPessoalResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AnuncioPessoalResponseDTO> update(@RequestBody AnuncioPessoalRequestDTO anuncioPessoalDTO,
                                                      @PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioPessoalService.update(anuncioPessoalDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioPessoalService.delete(id));
    }
}
