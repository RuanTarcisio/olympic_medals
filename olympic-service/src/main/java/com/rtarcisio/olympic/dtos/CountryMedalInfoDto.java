package com.rtarcisio.olympic.dtos;

import lombok.Data;

@Data
public class CountryMedalInfoDto {

    private Long id;

    private String countryName;

    private String countryCode;

    private Integer qtdGold;

    private Integer qtdSilver;

    private Integer qtdBronze;

    private Integer totalMedals;
}
