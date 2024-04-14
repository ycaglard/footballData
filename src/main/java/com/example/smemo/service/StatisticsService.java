package com.example.smemo.service;

import com.example.smemo.dto.StatisticsDTO;

public interface StatisticsService {
    StatisticsDTO findLargestScoreGap();
    StatisticsDTO findLargestPointDifference();
    StatisticsDTO findMostRedCardsShown();
    StatisticsDTO findMostYellowCardsShown();
    StatisticsDTO findMostGoalsScored();
    StatisticsDTO findMostXg();
    StatisticsDTO findMostShotsTaken();
}
