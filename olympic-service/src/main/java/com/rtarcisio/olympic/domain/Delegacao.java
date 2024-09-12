package com.rtarcisio.olympic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delegacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_delegacao;

    @OneToOne(mappedBy = "delegacao")
    private Country country;

    private int total_Atletas;

    @OneToMany
    @JoinColumn(name = "atleta_id")
    private List<Atleta> atletas;


    public void setId_delegacao(Long idDelegacao) {
        this.id_delegacao = idDelegacao;
    }

    public Long getId_delegacao() {
        return id_delegacao;
    }
}
