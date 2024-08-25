package com.rtarcisio.olympic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameSport;

    private String descriptionSport;

    private Integer qtdParticipants;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "sport")
    private MedalGold medalGold;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "sport")
    private MedalSilver medalSilver;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "sport")
    private MedalBronze medalBronze;
}
