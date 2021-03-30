package com.jun.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
