package com.matiwe.api_republikanos.dto.response;

import com.matiwe.api_republikanos.model.AnuncioPessoal;
import com.matiwe.api_republikanos.model.AnuncioRepublica;
import com.matiwe.api_republikanos.model.Usuario;
import lombok.Getter;

import java.util.Set;

@Getter
public class UsuarioResponseDTO {
    private Long id;

    private String login;

    private String senha;

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
