package com.rtarcisio.olympic.domain.enums;

public enum MedalType {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze");

    private String type;

    MedalType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

}
