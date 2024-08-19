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
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameSport;

    private String descriptionSport;

    private Integer qtdParticipants;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sport")
    private List<Medal> medals;
}
