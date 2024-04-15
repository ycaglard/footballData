package com.example.smemo.service;

import com.example.smemo.dto.StatisticsDTO;

import java.util.List;

public interface StatisticsService {
    StatisticsDTO findLargestScoreGap(List<StatisticsDTO> scoreList);
    StatisticsDTO findLargestPointDifference();
    StatisticsDTO findMostRedCardsShown();
    StatisticsDTO findMostYellowCardsShown();
    StatisticsDTO findMostGoalsScored(List<StatisticsDTO> scoreList);
    StatisticsDTO findMostXg();
    StatisticsDTO findMostShotsTaken();

    void saveStatistics();
}
