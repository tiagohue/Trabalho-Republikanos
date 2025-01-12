package com.matiwe.api_republikanos.model;

import com.matiwe.api_republikanos.model.enums.Comodo;
import com.matiwe.api_republikanos.model.enums.Servico;
import com.matiwe.api_republikanos.model.enums.Vaga;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TB_ANUNCIO_REPUBLICA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioRepublica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private double valor;

    @Column
    private String descricao;

    @ElementCollection()
    @JoinTable(name = "TB_REPUBLICA_COMODO")
    private List<Comodo> comodos;

    @ElementCollection
    @JoinTable(name = "TB_REPUBLICA_SERVICO")
    private List<Servico> servicos;

    @ElementCollection
    @JoinTable(name = "TB_REPUBLICA_VAGA")
    private List<Vaga> vagas;

    @OneToOne
    private Localizacao localizacao;

    @ManyToOne
    private Contato contato;

    @Builder
    public AnuncioRepublica(double valor, String descricao, List<Comodo> comodos, List<Servico> servicos,
                            List<Vaga> vagas, Localizacao localizacao, Contato contato) {
        this.valor = valor;
        this.descricao = descricao;
        this.comodos = comodos;
        this.servicos = servicos;
        this.vagas = vagas;
        this.localizacao = localizacao;
        this.contato = contato;
    }
}
