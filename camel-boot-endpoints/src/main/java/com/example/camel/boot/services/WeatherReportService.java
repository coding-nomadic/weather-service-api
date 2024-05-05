package com.example.camel.boot.services;

import com.example.camel.boot.entity.WeatherReport;
import com.example.camel.boot.exceptions.ResourceNotFoundException;
import com.example.camel.boot.repository.WeatherReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WeatherReportService {

    private final WeatherReportRepository weatherReportRepository;

    @Autowired
    public WeatherReportService(WeatherReportRepository weatherReportRepository) {
        this.weatherReportRepository = weatherReportRepository;
    }

    public List<WeatherReport> fetchAllReports() {
        return Optional.of(weatherReportRepository.findAll()).orElse(Collections.emptyList());
    }

    public WeatherReport fetchById(String id) {
        return weatherReportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found with given ID", "102"));
    }

    public List<WeatherReport> fetchAllByHumidity(double humidity) {
        return weatherReportRepository.findAllWithHumidityEqual(humidity).orElseThrow(() -> new ResourceNotFoundException("Null or empty List", "102"));
    }

    public List<WeatherReport> findAllWithTemp(double temp) {
        return weatherReportRepository.findAllWithTempEqual(temp).orElseThrow(() -> new ResourceNotFoundException("Null or empty List", "102"));
    }
}
