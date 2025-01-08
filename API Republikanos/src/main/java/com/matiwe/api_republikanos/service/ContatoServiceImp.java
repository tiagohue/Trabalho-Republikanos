package com.matiwe.api_republikanos.service;

import com.matiwe.api_republikanos.dto.request.ContatoRequestDTO;
import com.matiwe.api_republikanos.dto.response.ContatoResponseDTO;
import com.matiwe.api_republikanos.model.Contato;
import com.matiwe.api_republikanos.repository.ContatoRepository;
import com.matiwe.api_republikanos.util.ContatoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ContatoServiceImp implements ContatoService{
    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;

    @Override
    public ContatoResponseDTO findById(Long id) {
        return contatoMapper.toContatoDTO(returnContato(id));
    }

    @Override
    public List<ContatoResponseDTO> findAll() {
        return contatoMapper.toContatoDTO(contatoRepository.findAll());
    }

    @Override @Transactional
    public ContatoResponseDTO register(ContatoRequestDTO contatoDTO) {
        Contato contato = contatoMapper.toContato(contatoDTO);

        return contatoMapper.toContatoDTO(contatoRepository.save(contato));
    }

    @Override @Transactional
    public Contato registerByRepublica(ContatoRequestDTO contatoDTO) {
        Contato contato = contatoMapper.toContato(contatoDTO);

        //procura se a contato já existe
        List<Contato> contatos = contatoRepository.findContatoByTelefoneAndEmail(
                contato.getTelefone(), contato.getEmail());

        //cria a contato se ele nao existir
        if (contatos.isEmpty()) {
            return contatoRepository.save(contato);
        } else {
            return contatos.get(0);
        }
    }

    @Override @Transactional
    public ContatoResponseDTO update(ContatoRequestDTO contatoDTO, Long id) {
        Contato contato = returnContato(id);

        contatoMapper.updateContato(contato, contatoDTO);

        return contatoMapper.toContatoDTO(contatoRepository.save(contato));
    }

    @Override @Transactional
    public String delete(Long id) {
        contatoRepository.deleteById(id);
        return "Contato de id: " + id + " foi deletado.";
    }

    private Contato returnContato(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado."));
    }
}
