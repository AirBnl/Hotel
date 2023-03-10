package com.airbnl.hotelservice.service.interfaces;

import com.airbnl.hotelservice.model.Reservation;

import java.util.List;

public interface IReservationService {

    List<Reservation> getRoomReservationsByUserId(int userId);
    Reservation makeReservation(Reservation reservation);
}
