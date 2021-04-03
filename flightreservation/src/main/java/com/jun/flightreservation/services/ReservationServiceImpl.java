package com.jun.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.jun.flightreservation.dto.ReservationRequest;
import com.jun.flightreservation.entities.Flight;
import com.jun.flightreservation.entities.Passenger;
import com.jun.flightreservation.entities.Reservation;
import com.jun.flightreservation.repos.FlightRepository;
import com.jun.flightreservation.repos.PassengerRepository;
import com.jun.flightreservation.repos.ReservationRepository;

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;
    
    @Autowired
    PassengerRepository passengerRepository;
    
    @Autowired
    ReservationRepository reservationRepository;
    
    @Override
    public Reservation bookFlight(ReservationRequest request) {
        // Make Payment through a third party software
        
        Long flightId = request.getFlihgtId();
        Flight flight = flightRepository.findById(flightId).get();
        
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setPhone(request.getPassengerEmail());
        Passenger savedPassenger = passengerRepository.save(passenger);
        
        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);
        
        return savedReservation;
    }

}
