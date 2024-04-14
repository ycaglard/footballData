package com.example.smemo.mapper.impl;

import com.example.smemo.model.LeagueWrapper;
import com.example.smemo.model.Match;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.example.smemo.dto.StatisticsDTO;
import com.example.smemo.mapper.StatisticsMapper;
import com.example.smemo.model.League;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatisticsMapperImpl implements StatisticsMapper {

    @Override
    public LeagueWrapper jsonToDto(String jsonResponse) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LeagueWrapper parsed = mapper.readValue(jsonResponse, LeagueWrapper.class);

        return parsed;
    }
}
