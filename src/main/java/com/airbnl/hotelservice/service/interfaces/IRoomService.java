package com.airbnl.hotelservice.service.interfaces;

import com.airbnl.hotelservice.model.Hotel;
import com.airbnl.hotelservice.model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getRoomsByHotelId(Hotel hotel);
    List<Room> getRoomsByCountryAndRoomTypeIds(long countryId,long roomTypeId);
    Room getRoomById(long roomId);
}
