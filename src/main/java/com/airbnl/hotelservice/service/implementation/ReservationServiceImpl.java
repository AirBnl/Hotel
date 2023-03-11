package com.airbnl.hotelservice.service.implementation;

import com.airbnl.hotelservice.model.Reservation;
import com.airbnl.hotelservice.service.interfaces.IReservationService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    private final WebClient webClient;

    public ReservationServiceImpl(WebClient databaseWebClient) {
        this.webClient = databaseWebClient;
    }

    @Override
    public List<Reservation> getRoomReservationsByUserId(int userId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/reservation/getRoomReservationsByUserId")
                        .queryParam("userId", userId)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Reservation>>() {
                })
                .block();
    }

    @Override
    public Reservation makeReservation(Reservation reservation) {
        return webClient.post()
                .uri("/reservation/save")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(reservation), Reservation.class)
                .retrieve()
                .bodyToMono(Reservation.class)
                .block();
    }
}
