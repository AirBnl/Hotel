package com.airbnl.hotelservice.service.interfaces;

import com.airbnl.hotelservice.model.RoomType;

import java.util.List;

public interface IRoomTypeService {
    List<RoomType> getAllRoomTypes();

    List<RoomType> getAllRoomTypesByHotelID(long hotelId);

    RoomType getRoomTypeById(long roomTypeId);
}
