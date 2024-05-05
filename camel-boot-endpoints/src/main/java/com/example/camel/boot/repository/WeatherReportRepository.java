package com.example.camel.boot.repository;

import com.example.camel.boot.entity.WeatherReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherReportRepository extends MongoRepository<WeatherReport, String> {

    @Query("{ 'main.humidity': ?0 }")
    public Optional<List<WeatherReport>> findAllWithHumidityEqual(double humidityThreshold);


    @Query("{ 'main.temp': ?0 }")
    public Optional<List<WeatherReport>> findAllWithTempEqual(double temp);
}
