package com.rtarcisio.olympic.controllers;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.domain.Sport;
import com.rtarcisio.olympic.dtos.CountryDto;
import com.rtarcisio.olympic.dtos.CountryMedalDto;
import com.rtarcisio.olympic.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
DEVELOPED BY RUAN TARCISIO
 */
@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {


    private final CountryService countryService;

    @GetMapping("/all")
    public ResponseEntity<List<CountryDto>> getAllCountrys() {

        List<CountryDto> allCountrys = countryService.getAllCountrys();
        return ResponseEntity.ok(allCountrys);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryMedalDto> getCountry(@PathVariable Long id) {
        Country country = countryService.getCountryById(id);
        CountryMedalDto countryMedalDto = countryService.getCountryMedalDto(country);
        return ResponseEntity.ok(countryMedalDto);
    }

    @GetMapping(value = "/code")
    public ResponseEntity<CountryMedalDto> getCountryByCode(@RequestParam String countryCode) {
        Country country = countryService.getCountryByCode(countryCode);
        CountryMedalDto countryMedalDto = countryService.getCountryMedalDto(country);
        return ResponseEntity.ok(countryMedalDto);
    }

    @GetMapping(value = "/all-medals")
    public ResponseEntity<List<CountryMedalDto>> getAllCountryMedals() {

        List<CountryMedalDto> countrysMedalsDtos = countryService.getAllCountrysMedals();

        return ResponseEntity.ok(countrysMedalsDtos);

    }

}
