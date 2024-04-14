package com.example.smemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class League {
    private String ccode;
    private int id;
    @JsonProperty("primaryId")
    private int primaryId;
    private String name;
    private List<Match> matches;
    private int internalRank;
    private int liveRank;
    private boolean simpleLeague;
    private Integer parentLeagueId;

    // Getters and setters
}
