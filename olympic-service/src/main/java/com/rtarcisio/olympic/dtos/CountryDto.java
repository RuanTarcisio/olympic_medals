package com.rtarcisio.olympic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private Long id;

    private String countryName;

    private String countryCode;
}
