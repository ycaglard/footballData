package com.example.smemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MatchStatus {
    private String utcTime;
    private boolean finished;
    private boolean started;
    private boolean cancelled;
    private String scoreStr;
    private StatusReason reason;

    private String aggregatedStr; // Add this field

    // Getters and setters
}
