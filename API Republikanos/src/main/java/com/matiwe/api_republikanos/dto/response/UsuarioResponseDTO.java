package com.matiwe.api_republikanos.dto.response;

import com.matiwe.api_republikanos.model.AnuncioPessoal;
import com.matiwe.api_republikanos.model.AnuncioRepublica;
import com.matiwe.api_republikanos.model.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.Set;

@Getter
public class UsuarioResponseDTO {
    private Long id;

    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;

    Set<AnuncioRepublica> republicas;

    Set<AnuncioPessoal> anuncios;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.nome = usuario.getNome();
        this.republicas = usuario.getRepublicas();
        this.anuncios = usuario.getAnuncios();
    }
}
