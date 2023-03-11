package com.airbnl.hotelservice.controller;

import com.airbnl.hotelservice.model.Country;
import com.airbnl.hotelservice.model.Reservation;
import com.airbnl.hotelservice.model.Room;
import com.airbnl.hotelservice.model.RoomType;
import com.airbnl.hotelservice.service.interfaces.ICountryService;
import com.airbnl.hotelservice.service.interfaces.IReservationService;
import com.airbnl.hotelservice.service.interfaces.IRoomService;
import com.airbnl.hotelservice.service.interfaces.IRoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HotelController {
    private final ICountryService countryService;
    private final IRoomTypeService roomTypeService;
    private final IRoomService roomService;
    private final IReservationService reservationService;
    public static long userId = 1;

    public HotelController(ICountryService countryService, IRoomTypeService roomTypeService, IRoomService roomService, IReservationService reservationService) {
        this.countryService = countryService;
        this.roomTypeService = roomTypeService;
        this.roomService = roomService;
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Country> countries = countryService.getAllCountries();
        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        model.addAttribute("countries", countries);
        model.addAttribute("roomTypes", roomTypes);
        return "home";
    }

    @GetMapping("/search")
    public String search(@RequestParam("countryId") long countryId, @RequestParam("roomTypeId") long roomTypeId, Model model) {
        List<Room> rooms = roomService.getRoomsByCountryAndRoomTypeIds(countryId, roomTypeId);
        model.addAttribute("rooms", rooms);

        return "roomList";
    }

    @PostMapping("/reserve")
    public String reserve(@RequestParam("roomId") long roomId, @RequestParam("roomTypeId") long roomTypeId, Model model) {
        RoomType roomType = roomTypeService.getRoomTypeById(roomTypeId);
        Reservation reservation = reservationService.makeReservation(new Reservation(-1, userId, roomId, roomType.getPrice(), null, null));

        model.addAttribute("reservation", reservation);

        return "reservation-confirmation";
    }

    @GetMapping("/reservations")
    public String showReservations(Model model) {
        List<Reservation> reservations = reservationService.getRoomReservationsByUserId(userId);

        model.addAttribute("reservations", reservations);

        return "reservations";
    }

}
