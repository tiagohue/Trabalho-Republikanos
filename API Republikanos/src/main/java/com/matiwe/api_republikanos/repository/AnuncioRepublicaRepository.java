package com.matiwe.api_republikanos.repository;

import com.matiwe.api_republikanos.model.AnuncioRepublica;
import com.matiwe.api_republikanos.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnuncioRepublicaRepository extends JpaRepository<AnuncioRepublica, Long> {

    List<AnuncioRepublica> findAnuncioRepublicaByLocalizacao(Localizacao localizacao);
}
