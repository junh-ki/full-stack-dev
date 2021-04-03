package com.jun.flightreservation.services;

import com.jun.flightreservation.dto.ReservationRequest;
import com.jun.flightreservation.entities.Reservation;

public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
    
}
