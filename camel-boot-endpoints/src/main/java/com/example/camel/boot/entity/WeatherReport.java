package com.example.camel.boot.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Document(collection = "weather_reports")
public class WeatherReport {
    @Id
    private String id;
    private Map<String, Double> coord;
    private List<Map<String, Object>> weather;
    private String base;
    private Map<String, Double> main;
    private Integer visibility;
    private Map<String, Double> wind;
    private Map<String, Integer> clouds;
    private Long dt;
    private Map<String, Object> sys;
    private Integer timezone;
    private Integer cityId;
    private String name;
    private Integer cod;
}
