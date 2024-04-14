package com.example.smemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private int id;
    private int score;
    private String name;
    private String longName;
    private Integer redCards;

    // Getters and setters
}