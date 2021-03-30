package com.jun.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
