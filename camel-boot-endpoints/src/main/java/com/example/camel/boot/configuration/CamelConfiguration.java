package com.example.camel.boot.configuration;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CamelConfiguration {
    @Bean
    public CamelContext camelContext() {
        return new DefaultCamelContext();
    }
}
