package com.rtarcisio.medals_sportsservice.services;

import com.rtarcisio.medals_sportsservice.domain.Sport;
import com.rtarcisio.medals_sportsservice.repositories.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportService {

    private final SportRepository sportRepository;

    public Page<Sport> getAllSports(Pageable pageable) {

        return sportRepository.findAll(pageable);

    }
}
