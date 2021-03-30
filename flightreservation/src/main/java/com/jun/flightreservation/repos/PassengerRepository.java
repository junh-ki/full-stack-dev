package com.jun.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
