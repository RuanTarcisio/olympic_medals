package com.rtarcisio.olympic.services;

import com.rtarcisio.olympic.domain.Country;
import com.rtarcisio.olympic.domain.Medal;
import com.rtarcisio.olympic.domain.Sport;
import com.rtarcisio.olympic.repositories.MedalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedalService {

    private final MedalRepository medalRepository;

    private final CountryService countryService;

    private final SportService sportService;

    public Page<Medal> getAllMedals(Pageable pageable) {

        return medalRepository.findAll(pageable);
    }

    public Medal getMedalById(Long id) {

        return medalRepository.findById(id).orElseThrow(() ->new RuntimeException("Sport não cadastrado."));
    }

    public Medal getAllMedalsByType(String name) {
        return medalRepository.findAllByType(name).orElseThrow(() ->new RuntimeException("Sport não cadastrado."));
    }

    public Medal getAllMedalsByCountry(String name) {
        Country country = countryService.getCountryByName(name);
        return medalRepository.findAllByCountry(country).orElseThrow(() ->new RuntimeException("Sport não cadastrado."));
    }

    public Medal getAllMedalsBySport(String name) {
        Sport sport = sportService.getSportByName(name);
        return medalRepository.findAllBySport(sport).orElseThrow(() ->new RuntimeException("Sport não cadastrado."));
    }



}
