package com.matiwe.api_republikanos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_ANUNCIO_PESSOAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioPessoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column
    private String profissao;

    @Column
    private String gostos;

    @Column
    private String habitos;

    @Column
    private String habilidades;

    @Column
    private int idade;

    @Column(name = "bairro_interesse")
    private String bairroInteresse;

    @Column(name = "valor_limite")
    private double valorLimite;

    @ManyToOne
    private Contato contato;

    @Builder
    public AnuncioPessoal(String profissao, String gostos, String habitos, String habilidades, int idade,
                          String bairroInteresse, double valorLimite) {
        this.profissao = profissao;
        this.gostos = gostos;
        this.habitos = habitos;
        this.habilidades = habilidades;
        this.idade = idade;
        this.bairroInteresse = bairroInteresse;
        this.valorLimite = valorLimite;
    }
}
