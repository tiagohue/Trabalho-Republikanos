package com.matiwe.api_republikanos.controller;

import com.matiwe.api_republikanos.dto.request.AnuncioRepublicaRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioRepublicaResponseDTO;
import com.matiwe.api_republikanos.repository.AnuncioRepublicaRepository;
import com.matiwe.api_republikanos.service.AnuncioRepublicaService;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnuncioRepublicaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioRepublicaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AnuncioRepublicaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(anuncioRepublicaService.findAll());
    }

    @PostMapping
    public ResponseEntity<AnuncioRepublicaResponseDTO> register(
            @RequestBody AnuncioRepublicaRequestDTO anuncioRepublicaRequestDTO,
            UriComponentsBuilder uriBuilder) {

        AnuncioRepublicaResponseDTO anuncioRepublicaResponseDTO = anuncioRepublicaService.register(anuncioRepublicaRequestDTO);
        URI uri = uriBuilder.path("/anuncioRepublicas/{id}").buildAndExpand(anuncioRepublicaResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(anuncioRepublicaResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AnuncioRepublicaResponseDTO> update(@RequestBody AnuncioRepublicaRequestDTO anuncioRepublicaDTO,
                                                      @PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioRepublicaService.update(anuncioRepublicaDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(anuncioRepublicaService.delete(id));
    }
}
