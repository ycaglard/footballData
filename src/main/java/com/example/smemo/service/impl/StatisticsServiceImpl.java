package com.example.smemo.service.impl;

import com.example.smemo.dto.StatisticsDTO;
import com.example.smemo.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Override
    public StatisticsDTO findLargestScoreGap(List<StatisticsDTO> scoreList) {
        int max = -1;
        StatisticsDTO largestGap = null;
        for(StatisticsDTO statistics : scoreList){
            int gap = findGap(statistics.getOutcome());
            if(max < gap){
                largestGap = statistics;
                max = gap;
            }
        }
        return largestGap;
    }

    @Override
    public StatisticsDTO findLargestPointDifference() {
        return null;
    }

    @Override
    public StatisticsDTO findMostRedCardsShown() {
        return null;
    }

    @Override
    public StatisticsDTO findMostYellowCardsShown() {
        return null;
    }

    @Override
    public StatisticsDTO findMostGoalsScored(List<StatisticsDTO> scoreList) {
        int max = -1;
        StatisticsDTO maxGoalsStatistics = null;
        for(StatisticsDTO statisticsDTO : scoreList){
            int maxFound = maxGoal(statisticsDTO.getOutcome());
            if(max<maxFound){
                max = maxFound;
                maxGoalsStatistics = statisticsDTO;
            }
        }
        return maxGoalsStatistics;
    }

    @Override
    public StatisticsDTO findMostXg() {
        return null;
    }

    @Override
    public StatisticsDTO findMostShotsTaken() {
        return null;
    }

    @Override
    public void saveStatistics() {

    }

    private int findGap(String result){

        String[] results = result.split(" - ");

        return Math.abs(Integer.parseInt(results[0]) - Integer.parseInt(results[1]));
    }

    private int maxGoal(String result){
        String[] results = result.split(" - ");
        return Integer.parseInt(results[0]) + Integer.parseInt(results[1]);
    }
}
