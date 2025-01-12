package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.AnuncioPessoalRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioPessoalResponseDTO;
import com.matiwe.api_republikanos.model.AnuncioPessoal;
import com.matiwe.api_republikanos.repository.AnuncioPessoalRepository;
import com.matiwe.api_republikanos.util.AnuncioPessoalMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class AnuncioPessoalServiceImp implements AnuncioPessoalService{
    private final AnuncioPessoalRepository anuncioPessoalRepository;
    private final AnuncioPessoalMapper anuncioPessoalMapper;

    @Override
    public AnuncioPessoalResponseDTO findById(Long id) {
        return anuncioPessoalMapper.toAnuncioPessoalDTO(returnAnuncioPessoal(id));
    }

    @Override
    public List<AnuncioPessoalResponseDTO> findAll() {
        return anuncioPessoalMapper.toAnuncioPessoalDTO(anuncioPessoalRepository.findAll());
    }

    @Override @Transactional
    public AnuncioPessoalResponseDTO register(AnuncioPessoalRequestDTO anuncioPessoalDTO) {
        AnuncioPessoal anuncioPessoal = anuncioPessoalMapper.toAnuncioPessoal(anuncioPessoalDTO);

        return anuncioPessoalMapper.toAnuncioPessoalDTO(anuncioPessoalRepository.save(anuncioPessoal));
    }

    @Override @Transactional
    public AnuncioPessoalResponseDTO update(AnuncioPessoalRequestDTO anuncioPessoalDTO, Long id) {
        AnuncioPessoal anuncioPessoal = returnAnuncioPessoal(id);

        anuncioPessoalMapper.updateAnuncioPessoal(anuncioPessoal, anuncioPessoalDTO);

        return anuncioPessoalMapper.toAnuncioPessoalDTO(anuncioPessoalRepository.save(anuncioPessoal));
    }

    @Override @Transactional
    public String delete(Long id) {
        returnAnuncioPessoal(id);

        anuncioPessoalRepository.deleteById(id);
        return "AnuncioPessoal de id: " + id + " foi deletado.";
    }

    @Override
    public List<AnuncioPessoalResponseDTO> findByBairro(String bairro) {
        List<AnuncioPessoal> anuncios = anuncioPessoalRepository.findByBairroInteresseContainingIgnoreCase(bairro);

        return anuncioPessoalMapper.toAnuncioPessoalDTO(anuncios);
    }

    private AnuncioPessoal returnAnuncioPessoal(Long id) {
        return anuncioPessoalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AnuncioPessoal não encontrado."));
    }
}
