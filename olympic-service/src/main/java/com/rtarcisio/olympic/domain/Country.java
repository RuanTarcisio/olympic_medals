package com.rtarcisio.olympic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rtarcisio.olympic.domain.enums.MedalType;
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
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    private List<MedalGold> medalsGold;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    private List<MedalSilver> medalsSilver;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    private List<MedalBronze> medalBronze;
}
