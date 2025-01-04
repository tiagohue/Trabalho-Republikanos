package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.LocalizacaoRequestDTO;
import com.matiwe.api_republikanos.dto.response.LocalizacaoResponseDTO;
import com.matiwe.api_republikanos.model.Localizacao;
import com.matiwe.api_republikanos.repository.LocalizacaoRepository;
import com.matiwe.api_republikanos.util.LocalizacaoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class LocalizacaoServiceImp implements LocalizacaoService{
    private final LocalizacaoRepository localizacaoRepository;
    private final LocalizacaoMapper localizacaoMapper;

    @Override
    public LocalizacaoResponseDTO findById(Long id) {
        return localizacaoMapper.toLocalizacaoDTO(returnLocalizacao(id));
    }

    @Override
    public List<LocalizacaoResponseDTO> findAll() {
        return localizacaoMapper.toLocalizacaoDTO(localizacaoRepository.findAll());
    }

    @Override @Transactional
    public LocalizacaoResponseDTO register(LocalizacaoRequestDTO localizacaoDTO) {
        Localizacao localizacao = localizacaoMapper.toLocalizacao(localizacaoDTO);

        return localizacaoMapper.toLocalizacaoDTO(localizacaoRepository.save(localizacao));
    }

    @Override @Transactional
    public Localizacao registerByRepublica(LocalizacaoRequestDTO localizacaoDTO) {
        Localizacao localizacao = localizacaoMapper.toLocalizacao(localizacaoDTO);

        //procura se a localizacao já existe
        List<Localizacao> localizacoes = localizacaoRepository.findLocalizacaoByLogradouroAndNumeroAndBairro(
                localizacao.getLogradouro(), localizacao.getNumero(), localizacao.getBairro()
        );

        //cria a localizacao se ela nao existir
        if (localizacoes.isEmpty()) {
            return localizacaoRepository.save(localizacao);
        } else {
            return localizacoes.getFirst();
        }
    }

    @Override @Transactional
    public LocalizacaoResponseDTO update(LocalizacaoRequestDTO localizacaoDTO, Long id) {
        Localizacao localizacao = returnLocalizacao(id);

        localizacaoMapper.updateLocalizacao(localizacao, localizacaoDTO);

        return localizacaoMapper.toLocalizacaoDTO(localizacaoRepository.save(localizacao));
    }

    @Override @Transactional
    public String delete(Long id) {
        localizacaoRepository.deleteById(id);
        return "Localizacao de id: " + id + " foi deletado.";
    }

    private Localizacao returnLocalizacao(Long id) {
        return localizacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Localizacao não encontrado."));
    }
}
