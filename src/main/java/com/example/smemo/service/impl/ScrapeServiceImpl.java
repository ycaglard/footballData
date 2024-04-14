package com.example.smemo.service.impl;

import com.example.smemo.Enum.Type;
import com.example.smemo.dto.StatisticsDTO;
import com.example.smemo.mapper.StatisticsMapper;
import com.example.smemo.model.League;
import com.example.smemo.model.LeagueWrapper;
import com.example.smemo.model.Match;
import com.example.smemo.model.MatchStatus;
import com.example.smemo.service.ScrapeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

@NoArgsConstructor
@Service
public class ScrapeServiceImpl implements ScrapeService {
    @Value("${smemo.fotmoburl}")
    String externalApi;

    @Autowired
    StatisticsMapper statisticsMapper;

    @Override
    public List<StatisticsDTO> getScores(Date date) throws JsonProcessingException {
        RestTemplate rest= new RestTemplate();
        StringBuilder stringBuilder = new StringBuilder(externalApi).
                append("matches?date=").
                append(scrapeDate(date));

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> result =
                rest.exchange(stringBuilder.toString(), HttpMethod.GET, entity, String.class);

        LeagueWrapper leagueWrapper = statisticsMapper.jsonToDto(result.getBody());


        return getScoreList(leagueWrapper);
    }

    private String scrapeDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(date);
    }
    private List<StatisticsDTO> getScoreList(LeagueWrapper leagueWrapper) {
        List<League> leagues = leagueWrapper.getLeagues();
        List<StatisticsDTO> scoreList = new ArrayList<>();

        for (League league : leagues) {
            List<Match> matches = league.getMatches();

            for (Match match : matches) {
                MatchStatus status = match.getStatus();
                if (status != null && status.getScoreStr() != null) {
                    String homeTeamName = match.getHome().getName();
                    String awayTeamName = match.getAway().getName();

                    StatisticsDTO statisticsDTO = StatisticsDTO.builder()
                            .statisticsName("Result")
                            .owner(homeTeamName)
                            .against(awayTeamName)
                            .outcome(status.getScoreStr())
                            .description("Score of a match")
                            .statisticsType(Type.SCORE)
                            .league(league.getName())
                            .photoUrl("photourl")
                            .build();

                    scoreList.add(statisticsDTO);
                }
            }
        }

        return scoreList;
    }

}
