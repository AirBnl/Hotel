package com.airbnl.hotelservice.service.implementation;

import com.airbnl.hotelservice.model.Country;
import com.airbnl.hotelservice.model.Hotel;
import com.airbnl.hotelservice.service.interfaces.IHotelService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {

    private final WebClient webClient;

    public HotelServiceImpl(WebClient databaseWebClient) {
        this.webClient = databaseWebClient;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/hotel/getAllHotels")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Hotel>>() {
                })
                .block();
    }

    @Override
    public List<Hotel> getAllHotelsBasedOnTheCountry(Country country) {
        return getHotels(country);
    }

    private List<Hotel> getHotels(Country country) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/hotel/getAllHotelsBasedOnTheCountry")
                        .queryParam("countryId", country.getId())
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Hotel>>() {
                })
                .block();
    }
}
