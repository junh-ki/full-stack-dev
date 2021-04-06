package com.jun.flightcheckin.integration;

import com.jun.flightcheckin.integration.dto.Reservation;
import com.jun.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    public Reservation findReservation(Long id);

    public Reservation updateReservation(ReservationUpdateRequest request);

}
