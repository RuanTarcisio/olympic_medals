package com.rtarcisio.olympic.controllers;

import com.rtarcisio.olympic.dtos.MedalDto;
import com.rtarcisio.olympic.rabbit.events.MedalCreatedEvent;
import com.rtarcisio.olympic.services.MedalService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

    private final RabbitTemplate rabbitTemplate;

    private final MedalService medalService;

    @PostMapping("/create")
    public ResponseEntity<MedalDto> createMedal(@RequestBody MedalDto medalDto) {
        medalDto = medalService.saveMedal(medalDto);
        String routingKey = "olympic.medals-created";
        MedalCreatedEvent event = new MedalCreatedEvent(medalDto.getCountryName(), medalDto.getCountryCode(), medalDto.getType(), medalDto.getSportName());

        rabbitTemplate.convertAndSend(routingKey, event);
        return ResponseEntity.ok(medalDto);
    }

}
