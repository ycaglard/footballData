package com.example.smemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusReason {
    private String shortKey;
    private String longKey;
    @JsonProperty("short")
    private String _short;
    @JsonProperty("long")
    private String _long;

    // Getters and setters
}