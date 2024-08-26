package com.rtarcisio.olympic.dtos;

import lombok.Data;

@Data
public class CountryMedalDto {

    private String countryName;

    private String countryCode;

    private Integer qtdGold;

    private Integer qtdSilver;

    private Integer qtdBronze;

    private Integer totalMedals;
}
