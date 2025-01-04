package com.matiwe.api_republikanos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_CONTATO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column
    private String telefone;

    @Column
    private String email;

    @Builder
    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }
}
