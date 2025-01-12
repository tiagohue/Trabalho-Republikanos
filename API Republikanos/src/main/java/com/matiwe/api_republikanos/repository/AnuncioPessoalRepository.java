package com.matiwe.api_republikanos.repository;

import com.matiwe.api_republikanos.model.AnuncioPessoal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnuncioPessoalRepository extends JpaRepository<AnuncioPessoal, Long> {

    List<AnuncioPessoal> findByBairroInteresseContainingIgnoreCase(String bairroInteresse);
}
