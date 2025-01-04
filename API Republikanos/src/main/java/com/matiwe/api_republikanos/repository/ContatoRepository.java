package com.matiwe.api_republikanos.repository;

import com.matiwe.api_republikanos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    List<Contato> findContatoByTelefoneAndEmail(String telefone, String email);
}
