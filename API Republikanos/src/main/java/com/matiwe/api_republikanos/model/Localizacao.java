package com.matiwe.api_republikanos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_LOCALIZACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column
    private String logradouro;

    @Column
    private String numero;

    @Column
    private String bairro;

    @Builder
    public Localizacao(String logradouro, String numero, String bairro) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }
}
