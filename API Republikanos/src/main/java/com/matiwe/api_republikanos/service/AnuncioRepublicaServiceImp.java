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

import java.security.MessageDigest;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class AnuncioRepublicaServiceImp implements AnuncioRepublicaService{
    private final AnuncioRepublicaRepository anuncioRepublicaRepository;
    private final AnuncioRepublicaMapper anuncioRepublicaMapper;
    private final LocalizacaoRepository localizacaoRepository;
    private final LocalizacaoMapper localizacaoMapper;
    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;


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

        //procura se a localizacao já existe
        Localizacao localizacao = localizacaoMapper.toLocalizacao(anuncioRepublicaDTO.getLocalizacaoDTO());
        List<Localizacao> localizacoes = localizacaoRepository.findLocalizacaoByLogradouroAndNumeroAndBairro(
                localizacao.getLogradouro(), localizacao.getNumero(), localizacao.getBairro()
        );

        //adiciona a localizacao
        if (localizacoes.isEmpty()) {
            localizacaoRepository.save(localizacao);
            anuncioRepublica.setLocalizacao(localizacao);
        } else {
            anuncioRepublica.setLocalizacao(localizacoes.getFirst());
        }

        //procura se o contato já existe
        Contato contato = contatoMapper.toContato(anuncioRepublicaDTO.getContatoDTO());
        List<Contato> contatos = contatoRepository.findContatoByTelefoneAndEmail(
                contato.getTelefone(), contato.getEmail());

        //adiciona o contato
        if (contatos.isEmpty()) {
            contatoRepository.save(contato);
            anuncioRepublica.setContato(contato);
        } else {
            anuncioRepublica.setContato(contatos.getFirst());
        }

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
