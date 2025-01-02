package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.AnuncioRepublicaRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioRepublicaResponseDTO;
import com.matiwe.api_republikanos.model.AnuncioRepublica;
import com.matiwe.api_republikanos.repository.AnuncioRepublicaRepository;
import com.matiwe.api_republikanos.util.AnuncioRepublicaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class AnuncioRepublicaServiceImp implements AnuncioRepublicaService{
    private final AnuncioRepublicaRepository anuncioRepublicaRepository;
    private final AnuncioRepublicaMapper anuncioRepublicaMapper;

    @Override
    public AnuncioRepublicaResponseDTO findById(Long id) {
        return anuncioRepublicaMapper.toAnuncioRepublicaDTO(returnAnuncioRepublica(id));
    }

    @Override
    public List<AnuncioRepublicaResponseDTO> findAll() {
        return anuncioRepublicaMapper.toAnuncioRepublicaDTO(anuncioRepublicaRepository.findAll());
    }

    @Override @Transactional
    public AnuncioRepublicaResponseDTO register(AnuncioRepublicaRequestDTO anuncioRepublicaDTO) {
        AnuncioRepublica anuncioRepublica = anuncioRepublicaMapper.toAnuncioRepublica(anuncioRepublicaDTO);

        return anuncioRepublicaMapper.toAnuncioRepublicaDTO(anuncioRepublicaRepository.save(anuncioRepublica));
    }

    @Override @Transactional
    public AnuncioRepublicaResponseDTO update(AnuncioRepublicaRequestDTO anuncioRepublicaDTO, Long id) {
        AnuncioRepublica anuncioRepublica = returnAnuncioRepublica(id);

        anuncioRepublicaMapper.updateAnuncioRepublica(anuncioRepublica, anuncioRepublicaDTO);

        return anuncioRepublicaMapper.toAnuncioRepublicaDTO(anuncioRepublicaRepository.save(anuncioRepublica));
    }

    @Override @Transactional
    public String delete(Long id) {
        anuncioRepublicaRepository.deleteById(id);
        return "AnuncioRepublica de id: " + id + " foi deletado.";
    }

    private AnuncioRepublica returnAnuncioRepublica(Long id) {
        return anuncioRepublicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AnuncioRepublica não encontrado."));
    }
}
