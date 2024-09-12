package com.rtarcisio.olympic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Atleta;

    private String nome;

    @ManyToOne
    private Delegacao delegacao;

    @ManyToMany
    private List<Sport> sports;

    public void setId_Atleta(Long idAtleta) {
        this.id_Atleta = idAtleta;
    }

    public Long getId_Atleta() {
        return id_Atleta;
    }
}
