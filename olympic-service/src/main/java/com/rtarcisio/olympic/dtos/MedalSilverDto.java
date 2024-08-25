package com.rtarcisio.olympic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedalSilverDto {

    private Long id;

    private LocalDate awardDate;

    private String country_code;

    private String sportName;
}