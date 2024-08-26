package com.rtarcisio.olympic.services;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.domain.MedalBronze;
import com.rtarcisio.olympic.domain.Sport;
import com.rtarcisio.olympic.dtos.CountryDto;
import com.rtarcisio.olympic.dtos.CountryMedalDto;
import com.rtarcisio.olympic.repositories.CountryRepository;
import com.rtarcisio.olympic.repositories.MedalBronzeRepository;
import com.rtarcisio.olympic.repositories.MedalGoldRepository;
import com.rtarcisio.olympic.repositories.MedalSilverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final MedalSilverRepository medalSilverRepository;
    private final MedalGoldRepository medalGoldRepository;
    private final MedalBronzeRepository medalBronzeRepository;


    public Page<Country> getAllCountrys(Pageable pageable) {

        return countryRepository.findAll(pageable);
    }

    public Country getCountryById(Long id) {

        return countryRepository.findById(id).orElseThrow(() ->new RuntimeException("País não cadastrado."));
    }

    public Country getCountryByCode(String code) {
        return countryRepository.findByCode(code).orElseThrow(() ->new RuntimeException("País não cadastrado."));
    }

    public List<CountryMedalDto> getAllCountrysMedals() {

        List<Country>countries = countryRepository.findAll();
        List<CountryMedalDto> list = countries.stream()
                .map(this::getCountryMedalDto)  // Usa o método getCountryMedalDto para conversão
                .sorted(Comparator.comparing((CountryMedalDto countryMedalDto) -> countryMedalDto.getQtdGold()).reversed()
                        .thenComparing(countryMedalDto1 -> countryMedalDto1.getQtdSilver()).reversed()
                        .thenComparing(countryMedalDto2 -> countryMedalDto2.getQtdBronze()).reversed())
                .collect(Collectors.toList());  // Coleta em uma lista

        return list;
    }


    public CountryMedalDto getCountryMedalDto(Country country) {

        CountryMedalDto countryMedalDto = new CountryMedalDto();
        int totalMedals = 0;

        countryMedalDto.setQtdGold(country.getMedalsGold().size());
        countryMedalDto.setQtdSilver(country.getMedalsSilver().size());
        countryMedalDto.setQtdBronze(country.getMedalBronze().size());
        countryMedalDto.setCountryName(country.getName());
        countryMedalDto.setCountryCode(country.getCode());
        totalMedals = countryMedalDto.getQtdGold() + countryMedalDto.getQtdSilver() + countryMedalDto.getQtdBronze();
        countryMedalDto.setTotalMedals(totalMedals);


        return countryMedalDto;
    }

    private CountryDto countryDto(Country country){
        return new CountryDto(country.getCode(), country.getName());
    }

}
