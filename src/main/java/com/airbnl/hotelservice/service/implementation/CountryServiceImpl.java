package com.airbnl.hotelservice.service.implementation;

import com.airbnl.hotelservice.model.Country;
import com.airbnl.hotelservice.service.interfaces.ICountryService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {
    private final WebClient webClient;

    public CountryServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<Country> getAllCountries() {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/country/getAllCountries")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Country>>() {
                })
                .block();
    }
}

