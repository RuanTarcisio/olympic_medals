package com.rtarcisio.olympic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryMedalDto {

    private String country;
    private String countryCode;
    private List<MedalSportDto> medalsG;
    private List<MedalSportDto> medalsS;
    private List<MedalSportDto> medalsB;
}
