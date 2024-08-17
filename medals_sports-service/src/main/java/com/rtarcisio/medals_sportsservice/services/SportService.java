package com.rtarcisio.medals_sportsservice.services;

import com.rtarcisio.medals_sportsservice.domain.Sport;
import com.rtarcisio.medals_sportsservice.repositories.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportService {

    private final SportRepository sportRepository;

    public Page<Sport> getAllSports(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("nameSport").ascending());
        return sportRepository.findAll(pageable);
    }
}
