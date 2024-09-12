package com.rtarcisio.olympic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    private List<MedalGold> medalsGold;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    private List<MedalSilver> medalsSilver;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    private List<MedalBronze> medalBronze;

    @OneToOne
    @JoinColumn(name = "delegacao_id")
    private Delegacao delegacao;


}
