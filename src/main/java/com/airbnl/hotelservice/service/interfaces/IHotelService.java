package com.airbnl.hotelservice.service.interfaces;

import com.airbnl.hotelservice.model.Country;
import com.airbnl.hotelservice.model.Hotel;

import java.util.List;

public interface IHotelService {
    List<Hotel> getAllHotels();

    List<Hotel> getAllHotelsBasedOnTheCountry(Country country);

    Hotel getHotelById(long hotelId);
}
