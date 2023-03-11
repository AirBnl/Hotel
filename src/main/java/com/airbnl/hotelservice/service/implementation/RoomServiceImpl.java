package com.airbnl.hotelservice.service.implementation;

import com.airbnl.hotelservice.model.Hotel;
import com.airbnl.hotelservice.model.Room;
import com.airbnl.hotelservice.service.interfaces.IRoomService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {
    private final WebClient webClient;

    public RoomServiceImpl(WebClient databaseWebClient) {
        this.webClient = databaseWebClient;
    }

    @Override
    public List<Room> getRoomsByHotelId(Hotel hotel) {
        return null;
    }

    @Override
    public List<Room> getRoomsByCountryAndRoomTypeIds(long countryId, long roomTypeId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/room/getRoomsByCountryAndRoomTypeIds")
                        .queryParam("countryId", countryId)
                        .queryParam("roomTypeId", roomTypeId)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Room>>() {
                })
                .block();
    }

    private List<Room> getRooms(Hotel hotel) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/room/getRoomsByHotelId")
                        .queryParam("hotelId", hotel.getId())
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Room>>() {
                })
                .block();
    }
}
