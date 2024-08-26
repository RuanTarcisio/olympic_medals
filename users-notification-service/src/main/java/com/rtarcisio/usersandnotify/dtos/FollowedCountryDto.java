package com.rtarcisio.usersandnotify.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FollowedCountryDto {
    private List<Long> followedCountriesId;
}
