package com.rtarcisio.medals_sportsservice.domain;

import com.rtarcisio.medals_sportsservice.domain.enums.MedalType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    private Sport sport;

    @Enumerated(EnumType.STRING)
    private MedalType type;

    private LocalDate awardDate;

//    @ManyToOne
//    @JoinColumn(name = "country_id", nullable = false)
//    private Country country;
}
