package com.rtarcisio.olympic.converter;


import com.rtarcisio.olympic.domain.MedalBronze;
import com.rtarcisio.olympic.domain.MedalGold;
import com.rtarcisio.olympic.dtos.MedalBronzeDto;
import com.rtarcisio.olympic.dtos.MedalGoldDto;
import org.springframework.stereotype.Component;

@Component
public class MedalGoldConverter {

    public MedalGoldDto converterMedalToDto(MedalGold medal){

        MedalGoldDto medalGoldDto = new MedalGoldDto();
        medalGoldDto.setId(medal.getId());
        medalGoldDto.setAwardDate(medal.getAwardDate());
        medalGoldDto.setCountry_code(medal.getCountry().getCode());
        medalGoldDto.setSportName(medal.getSport().getNameSport());

        return medalGoldDto;
    }

//    public MedalGoldDto converterMedalToDto(MedalGold medal){
//
//        MedalGoldDto medalGoldDto = new MedalGoldDto();
//        medalGoldDto.setId(medal.getId());
//        medalGoldDto.setAwardDate(medal.getAwardDate());
//        medalGoldDto.setCountry_code(medal.getCountry().getCode());
//        medalGoldDto.setSportName(medal.getSport().getNameSport());
//
//        return medalGoldDto;
//    }
}
