package com.example.camel.boot.controllers;

import com.example.camel.boot.routes.WeatherReportRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.RouteController;
import org.apache.camel.support.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/routes")
public class RoutesController {

    @Autowired
    private WeatherReportRoute weatherReportRoute;

    @GetMapping(value = "/start/{routeId}")
    public String startWeatherReportRoute(String routeId) throws Exception {
        //RouteController routeController = camelContext.getRouteController();
        //routeController.startRoute("report-route");
        //camelContext.getRouteController().startAllRoutes();
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(weatherReportRoute);
        camelContext.start();
        return "camel " + routeId + " started successfully !";
    }
}
