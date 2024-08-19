package com.rtarcisio.olympic.controllers;

import com.rtarcisio.olympic.domain.Sport;
import com.rtarcisio.olympic.services.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*
DEVELOPED BY RUAN TARCISIO
 */
@RestController
@RequestMapping("/sport")
@RequiredArgsConstructor
public class SportController {

    private final SportService sportService;

    @GetMapping("/status")
    private String status(){
        return "ok";
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Sport>> getAllSports(Pageable pageable) {

        Page<Sport> sportsPage = sportService.getAllSports(pageable);
        return ResponseEntity.ok(sportsPage);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sport> getSportById(@PathVariable Long id) {
        return ResponseEntity.ok(sportService.getSportById(id));
    }

    @GetMapping(value = "/sportname")
    public ResponseEntity<Sport> getSportByName(@RequestParam String sportname) {
        return ResponseEntity.ok(sportService.getSportByName(sportname));
    }



}
