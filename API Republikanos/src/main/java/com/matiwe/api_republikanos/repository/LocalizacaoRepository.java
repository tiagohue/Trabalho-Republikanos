package com.matiwe.api_republikanos.repository;

import com.matiwe.api_republikanos.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {

    List<Localizacao> findLocalizacaoByLogradouroAndNumeroAndBairro(String logradouro, String numero, String bairro);
}
