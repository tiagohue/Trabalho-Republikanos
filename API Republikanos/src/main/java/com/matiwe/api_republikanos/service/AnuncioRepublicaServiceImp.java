package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.AnuncioRepublicaRequestDTO;
import com.matiwe.api_republikanos.dto.response.AnuncioRepublicaResponseDTO;
import com.matiwe.api_republikanos.model.AnuncioRepublica;
import com.matiwe.api_republikanos.model.Contato;
import com.matiwe.api_republikanos.model.Localizacao;
import com.matiwe.api_republikanos.repository.AnuncioRepublicaRepository;
import com.matiwe.api_republikanos.repository.ContatoRepository;
import com.matiwe.api_republikanos.repository.LocalizacaoRepository;
import com.matiwe.api_republikanos.util.AnuncioRepublicaMapper;
import com.matiwe.api_republikanos.util.ContatoMapper;
import com.matiwe.api_republikanos.util.LocalizacaoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class AnuncioRepublicaServiceImp implements AnuncioRepublicaService{
    private final AnuncioRepublicaRepository anuncioRepublicaRepository;
    private final AnuncioRepublicaMapper anuncioRepublicaMapper;
    private final LocalizacaoService localizacaoService;
    private final ContatoService contatoService;


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

        //cria a localizacao
        Localizacao localizacao = localizacaoService.registerByRepublica(anuncioRepublicaDTO.getLocalizacaoDTO());
        anuncioRepublica.setLocalizacao(localizacao);

        //cria o contato
        Contato contato = contatoService.registerByRepublica(anuncioRepublicaDTO.getContatoDTO());
        anuncioRepublica.setContato(contato);

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
        returnAnuncioRepublica(id);

        anuncioRepublicaRepository.deleteById(id);
        return "AnuncioRepublica de id: " + id + " foi deletado.";
    }

    private AnuncioRepublica returnAnuncioRepublica(Long id) {
        return anuncioRepublicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AnuncioRepublica não encontrado."));
    }

    public List<AnuncioRepublicaResponseDTO> findByBairro(String bairro){
        List<Localizacao> localizacoes = localizacaoService.findByBairro(bairro);

        List<AnuncioRepublica> republicas = new ArrayList<AnuncioRepublica>();

        for (Localizacao l : localizacoes) {
            republicas.addAll(anuncioRepublicaRepository.findAnuncioRepublicaByLocalizacao(l));
        }

        return anuncioRepublicaMapper.toAnuncioRepublicaDTO(republicas);
    }
}
