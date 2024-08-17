package com.rtarcisio.medals_sportsservice.controllers;

import com.rtarcisio.medals_sportsservice.domain.Medal;
import com.rtarcisio.medals_sportsservice.domain.Sport;
import com.rtarcisio.medals_sportsservice.services.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sport")
@RequiredArgsConstructor
public class SportController {

    private final SportService sportService;

    @GetMapping
    public Page<Sport> getMedals(
            @PageableDefault(size = 10, page = 0, sort = "type", direction = Sort.Direction.ASC) Pageable pageable) {
        return sportService.getAllSports    (pageable);
    }
}
