package com.rtarcisio.olympic.rabbit.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedalCreatedEvent {

    private String countryName;
    private String countryCode;
    private String typeMedal;
    private String sportName;

}