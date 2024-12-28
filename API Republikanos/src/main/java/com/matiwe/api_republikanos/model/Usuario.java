package com.matiwe.api_republikanos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;

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
