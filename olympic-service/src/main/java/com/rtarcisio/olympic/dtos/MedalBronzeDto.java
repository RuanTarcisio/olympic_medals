package com.rtarcisio.olympic.dtos;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.domain.Sport;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedalBronzeDto {

    private Long id;

    private LocalDate awardDate;

    private String country_code;

    private String sportName;
}
