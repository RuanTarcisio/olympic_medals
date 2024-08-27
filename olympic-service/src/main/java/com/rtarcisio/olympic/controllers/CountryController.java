package com.rtarcisio.olympic.controllers;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.dtos.CountryDto;
import com.rtarcisio.olympic.dtos.CountryMedalDto;
import com.rtarcisio.olympic.dtos.CountryMedalInfoDto;
import com.rtarcisio.olympic.services.CountryService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<CountryMedalInfoDto> getCountry(@PathVariable Long id) {
        Country country = countryService.getCountryById(id);
        CountryMedalInfoDto countryMedalInfoDto = countryService.getCountryMedalDto(country);
        return ResponseEntity.ok(countryMedalInfoDto);
    }

    @GetMapping(value = "/code")
    public ResponseEntity<CountryMedalInfoDto> getCountryByCode(@RequestParam String countryCode) {
        Country country = countryService.getCountryByCode(countryCode);
        CountryMedalInfoDto countryMedalInfoDto = countryService.getCountryMedalDto(country);
        return ResponseEntity.ok(countryMedalInfoDto);
    }

    @GetMapping(value = "/all-medals")
    public ResponseEntity<List<CountryMedalInfoDto>> getAllCountryMedals() {

        List<CountryMedalInfoDto> countrysMedalsDtos = countryService.getAllCountrysMedals();

        return ResponseEntity.ok(countrysMedalsDtos);

    }

    @GetMapping(value = "/medals/{id}")
    public ResponseEntity<CountryMedalDto> getCountryAllMedals(@PathVariable Long id) {

        CountryMedalDto countryMedalInfoDto = countryService.medalsCountry(id);
        return ResponseEntity.ok(countryMedalInfoDto);
    }

}
