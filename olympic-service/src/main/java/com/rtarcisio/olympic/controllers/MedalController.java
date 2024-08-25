package com.rtarcisio.olympic.controllers;

import com.rtarcisio.olympic.services.MedalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
DEVELOPED BY RUAN TARCISIO
 */
@RestController
@RequestMapping("/medal")
@RequiredArgsConstructor
public class MedalController {

    private final MedalService medalService;

//    @GetMapping("/all")
//    public ResponseEntity<Page<Medal>> getMedals(Pageable pageable) {
//
//        Page<Medal> medalsPage = medalService.getAllMedals(pageable);
//        return ResponseEntity.ok(medalsPage);
//    }
//
//    @GetMapping("/all-order")
//    public ResponseEntity<Map<String, List<Medal>>> getMedalsOrder( ) {
//
//        Map<String, List<Medal>> medalsPage = medalService.orderByType();
//        return ResponseEntity.ok(medalsPage);
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Medal> getMedalById(@PathVariable Long id) {
//        return ResponseEntity.ok(medalService.getMedalById(id));
//    }
//
//    @GetMapping(value = "/sport")
//    public ResponseEntity<Medal> getMedalBySport(@RequestParam String sport) {
//        return ResponseEntity.ok(medalService.getAllMedalsBySport(sport));
//    }
//
//    @GetMapping(value = "/type")
//    public ResponseEntity<Medal> getMedalByTypeMedal(@RequestParam String typeMedal) {
//        return ResponseEntity.ok(medalService.getAllMedalsByType(typeMedal));
//    }
//
//    @GetMapping(value = "/country")
//    public ResponseEntity<Medal> getMedalByCountry(@RequestParam String country) {
//        return ResponseEntity.ok(medalService.getAllMedalsByCountry(country));
//    }
}
