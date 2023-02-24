package com.airbnl.hotelservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${services.database.controller}")
    private String databaseController;

    @Bean
    public WebClient databaseWebClient(WebClient.Builder webClient) {
        return webClient.baseUrl(databaseController).build();
    }

}
