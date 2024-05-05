package com.example.camel.boot.controllers;

import com.example.camel.boot.entity.WeatherReport;
import com.example.camel.boot.services.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class WeatherReportingController {


    private final WeatherReportService weatherReportService;

    @Autowired
    public WeatherReportingController(WeatherReportService weatherReportService) {
        this.weatherReportService = weatherReportService;
    }

    @GetMapping
    public ResponseEntity<List<WeatherReport>> fetchAllWeatherReports() {
        List<WeatherReport> weatherReports = weatherReportService.fetchAllReports();
        return ResponseEntity.ok(weatherReports);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WeatherReport> fetchById(@PathVariable String id) {
        WeatherReport weatherReport = weatherReportService.fetchById(id);
        return ResponseEntity.ok(weatherReport);
    }

    @GetMapping(value = "/humidity/{humidity}")
    public ResponseEntity<List<WeatherReport>> fetchAllByHumidity(@PathVariable double humidity) {
        List<WeatherReport> weatherReports = weatherReportService.fetchAllByHumidity(humidity);
        return ResponseEntity.ok(weatherReports);
    }

    @GetMapping(value = "/temperature/{temperature}")
    public ResponseEntity<List<WeatherReport>> fetchAllByTemp(@PathVariable double temperature) {
        List<WeatherReport> weatherReports = weatherReportService.findAllWithTemp(temperature);
        return ResponseEntity.ok(weatherReports);
    }
}
