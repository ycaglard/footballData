package com.example.smemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    private int id;
    private int leagueId;
    private String time;
    private Team home;
    private Team away;
    private Integer eliminatedTeamId;
    private int statusId;
    private String tournamentStage;
    private MatchStatus status;
    private long timeTS;

}
