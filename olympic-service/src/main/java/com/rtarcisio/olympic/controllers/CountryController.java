package com.rtarcisio.olympic.controllers;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.domain.Sport;
import com.rtarcisio.olympic.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*
DEVELOPED BY RUAN TARCISIO
 */
@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {


    private final CountryService countryService;

    @GetMapping("/all")
    public ResponseEntity<Page<Country>> getAllCountrys(Pageable pageable) {

        Page<Country> sportsPage = countryService.getAllCountrys(pageable);
        return ResponseEntity.ok(sportsPage);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @GetMapping(value = "/name")
    public ResponseEntity<Country> getSportByName(@RequestParam String sportName) {
        return ResponseEntity.ok(countryService.getCountryByName(sportName));
    }

    @GetMapping(value = "/code")
    public ResponseEntity<Country> getSportByCode(@RequestParam String sportCode) {
        return ResponseEntity.ok(countryService.getCountryByCode(sportCode));
    }

}
