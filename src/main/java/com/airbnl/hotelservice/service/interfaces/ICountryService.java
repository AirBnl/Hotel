package com.airbnl.hotelservice.service.interfaces;

import com.airbnl.hotelservice.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();
    Country getCountryById(long id);
}
