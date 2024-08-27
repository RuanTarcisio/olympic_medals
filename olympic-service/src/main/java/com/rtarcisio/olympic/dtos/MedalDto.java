package com.rtarcisio.olympic.dtos;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedalDto {

    private Long id;


    @NotNull
    private String type;

    private LocalDate awardDate;

    @NotNull
    private String countryCode;

    @NotNull
    private String countryName;

    @NotNull
    private Long sportId;

    @NotNull
    private String sportName;
}