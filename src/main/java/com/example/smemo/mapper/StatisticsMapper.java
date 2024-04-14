package com.example.smemo.mapper;

import com.example.smemo.dto.StatisticsDTO;
import com.example.smemo.model.LeagueWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface StatisticsMapper {
    LeagueWrapper jsonToDto(String jsonResponse) throws JsonProcessingException;
}
