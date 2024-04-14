package com.example.smemo.dto;

import com.example.smemo.Enum.Type;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class StatisticsDTO {
    String statisticsName;
    Type statisticsType;
    String description;
    String outcome;
    String league;
    String owner;
    String against;
    String photoUrl;

}
