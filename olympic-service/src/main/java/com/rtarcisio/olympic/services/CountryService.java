package com.rtarcisio.olympic.services;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.domain.Sport;
import com.rtarcisio.olympic.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Page<Country> getAllCountrys(Pageable pageable) {

        return countryRepository.findAll(pageable);
    }

    public Country getCountryById(Long id) {

        return countryRepository.findById(id).orElseThrow(() ->new RuntimeException("País não cadastrado."));
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByName(name).orElseThrow(() ->new RuntimeException("País não cadastrado."));
    }

    public Country getCountryByCode(String code) {
        return countryRepository.findByCode(code).orElseThrow(() ->new RuntimeException("País não cadastrado."));
    }

}
