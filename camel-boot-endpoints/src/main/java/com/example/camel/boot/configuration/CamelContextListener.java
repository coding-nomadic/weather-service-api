package com.example.camel.boot.configuration;

import com.example.camel.boot.routes.WeatherReportRoute;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CamelContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CamelContext camelContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        camelContext.start();
    }
}