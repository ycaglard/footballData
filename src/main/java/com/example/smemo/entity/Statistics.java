package com.example.smemo.entity;

import com.example.smemo.Enum.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Statistics {
    @Id
    Long id;
    String name;
    Type statisticType;

    String description;
    String outcome;
    String owner;
    String against;
    String photoUrl;


}
