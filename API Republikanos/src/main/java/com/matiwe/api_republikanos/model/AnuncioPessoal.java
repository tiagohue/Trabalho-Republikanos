package com.matiwe.api_republikanos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANUNCIO_PESSOAL")
public class AnuncioPessoal {
    @Id
    private Long id;
}
