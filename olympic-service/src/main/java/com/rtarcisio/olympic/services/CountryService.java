package com.rtarcisio.olympic.services;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.dtos.CountryDto;
import com.rtarcisio.olympic.dtos.CountryMedalDto;
import com.rtarcisio.olympic.dtos.CountryMedalInfoDto;
import com.rtarcisio.olympic.repositories.CountryRepository;
import com.rtarcisio.olympic.repositories.MedalBronzeRepository;
import com.rtarcisio.olympic.repositories.MedalGoldRepository;
import com.rtarcisio.olympic.repositories.MedalSilverRepository;
import com.rtarcisio.olympic.services.exceptions.ObjetoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    private final MedalService medalService;


    public List<CountryDto> getAllCountrys() {

        List<Country> countries = countryRepository.findAllByOrderByNameAsc();
        List<CountryDto> dtos = countries.stream()
                .map(country -> countryDto(country))
                .collect(Collectors.toList());
        return dtos;
    }

    public Country getCountryById(Long id) {

        return countryRepository.findById(id).orElseThrow(() ->new ObjetoNaoEncontradoException("País não cadastrado."));
    }

    public Country getCountryByCode(String code) {
        return countryRepository.findByCode(code).orElseThrow(() ->new ObjetoNaoEncontradoException("País não cadastrado."));
    }

    public List<CountryMedalInfoDto> getAllCountrysMedals() {

        List<Country>countries = countryRepository.findAllByOrderByNameAsc();
        List<CountryMedalInfoDto> list = countries.stream()
                .map(this::getCountryMedalDto)
                .sorted(Comparator.comparing((CountryMedalInfoDto countryMedalInfoDto) -> countryMedalInfoDto.getQtdGold()).reversed()
                        .thenComparing(countryMedalInfoDto1 -> countryMedalInfoDto1.getQtdSilver()).reversed()
                        .thenComparing(countryMedalInfoDto2 -> countryMedalInfoDto2.getQtdBronze()).reversed())
                .collect(Collectors.toList());

        return list;
    }


    public CountryMedalInfoDto getCountryMedalDto(Country country) {

        CountryMedalInfoDto countryMedalInfoDto = new CountryMedalInfoDto();
        int totalMedals = 0;

        countryMedalInfoDto.setId(country.getId());
        countryMedalInfoDto.setQtdGold(country.getMedalsGold().size());
        countryMedalInfoDto.setQtdSilver(country.getMedalsSilver().size());
        countryMedalInfoDto.setQtdBronze(country.getMedalBronze().size());
        countryMedalInfoDto.setCountryName(country.getName());
        countryMedalInfoDto.setCountryCode(country.getCode());
        totalMedals = countryMedalInfoDto.getQtdGold() + countryMedalInfoDto.getQtdSilver() + countryMedalInfoDto.getQtdBronze();
        countryMedalInfoDto.setTotalMedals(totalMedals);

        return countryMedalInfoDto;
    }

    public CountryMedalDto medalsCountry(Long countryId){
        Country country = getCountryById(countryId);
        CountryMedalDto countryMedalDto = new CountryMedalDto();

        countryMedalDto.setCountry(country.getName());
        countryMedalDto.setCountryCode(country.getCode());
        countryMedalDto.setMedalsG(medalService.medalsGold(country.getMedalsGold()));
        countryMedalDto.setMedalsS(medalService.medalsSilver(country.getMedalsSilver()));
        countryMedalDto.setMedalsB(medalService.medalsBronze(country.getMedalBronze()));

        return countryMedalDto;
    }



    private CountryDto countryDto(Country country){
        return new CountryDto(country.getId(), country.getName(),country.getCode());
    }


}
