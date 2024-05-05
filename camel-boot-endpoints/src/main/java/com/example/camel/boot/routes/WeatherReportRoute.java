package com.example.camel.boot.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * Fetching weather details every 15 mins from weather API and stores in MongoDB for further reporting
 */
@Component
public class WeatherReportRoute extends RouteBuilder {

    @Value("${weather.host}")
    private String host;
    @Value("${weather.apikey}")
    private String apiKey;
    @Value("${weather.port}")
    private String port;
    @Value("${weather.city}")
    private String city;
    @Value("${weather.interval}")
    private String interval;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.collection}")
    private String collection;

    @Override
    public void configure() throws Exception {
        configureErrorHandling();
        configureRestConfiguration();
        configureWeatherRoute();
    }

    private void configureRestConfiguration() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json).contextPath("camel").host(host).port(port);
    }

    private void configureWeatherRoute() {
        from("timer:rest-client?period=" + interval).routeId("report-route").to(buildWeatherEndpoint()).unmarshal().json().to("mongodb:" + collection + "?database=" + database + "&collection=" + collection + "&operation=insert").log("${body}");
    }

    private String buildWeatherEndpoint() {
        return String.format("rest:get:?q=%s&units=metric&appid=%s", city, apiKey);
    }

    private void configureErrorHandling() {
        onException(Exception.class).handled(true).log("Exception occurred: ${exception.message}").to("direct:errorHandlingRoute");
    }
}

