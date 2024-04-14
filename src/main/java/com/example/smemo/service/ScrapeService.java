package com.example.smemo.service;

import com.example.smemo.dto.StatisticsDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Date;
import java.util.List;

public interface ScrapeService {
    List<StatisticsDTO> getScores(Date date) throws JsonProcessingException;
}
