package com.airbnl.hotelservice.service.implementation;

import com.airbnl.hotelservice.model.RoomType;
import com.airbnl.hotelservice.service.interfaces.IRoomTypeService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements IRoomTypeService {
    private final WebClient webClient;

    public RoomTypeServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<RoomType> getAllRoomTypes() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/roomType/getAllRoomTypes")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<RoomType>>() {
                })
                .block();
    }

    @Override
    public List<RoomType> getAllRoomTypesByHotelID(int hotelId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/roomType/getAllRoomTypesByCountryID")
                        .queryParam("hotelId", hotelId)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<RoomType>>() {
                })
                .block();
    }

    @Override
    public RoomType getRoomTypeById(int roomTypeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/roomType/getRoomTypeById")
                        .queryParam("roomTypeId", roomTypeId)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(RoomType.class)
                .block();
    }
}
