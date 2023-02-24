package com.airbnl.hotelservice.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DatabaseServiceImpl {

    private final WebClient webClient;

    public DatabaseServiceImpl(WebClient databaseWebClient) {
        this.webClient = databaseWebClient;
    }
}
