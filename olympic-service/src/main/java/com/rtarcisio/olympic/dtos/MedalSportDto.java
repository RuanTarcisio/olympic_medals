package com.rtarcisio.olympic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedalSportDto {
    private String type;
    private String sport;
    private LocalDate awardDate;
}
