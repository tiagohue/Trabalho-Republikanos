package com.matiwe.api_republikanos.repository;

import com.matiwe.api_republikanos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
