package com.rtarcisio.olympic.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedalDto {

    private Long id;

    @NotBlank
    private String type;

    private LocalDate awardDate;

    @NotBlank
    private String countryCode;

    @NotBlank
    private String countryName;

    @NotBlank
    private Long sportId;

    @NotBlank
    private String sportName;
}