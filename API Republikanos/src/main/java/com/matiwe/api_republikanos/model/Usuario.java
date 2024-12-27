package com.matiwe.api_republikanos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "USUARIO")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    Long id;

    @Column(nullable = false)
    String login;

    @Column(nullable = false)
    String senha;

    @Column(nullable = false)
    String nome;

    @OneToMany()
    @JoinColumn(name = "fk_usuario_id")
    Set<AnuncioRepublica> republicas;

    @OneToMany()
    @JoinColumn(name = "fk_usuario_id")
    Set<AnuncioPessoal> anuncios;

    @Builder
    public Usuario(String login, String senha, String nome) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
    }
}
