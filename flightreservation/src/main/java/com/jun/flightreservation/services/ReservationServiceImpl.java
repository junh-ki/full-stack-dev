package com.jun.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.flightreservation.dto.ReservationRequest;
import com.jun.flightreservation.entities.Flight;
import com.jun.flightreservation.entities.Passenger;
import com.jun.flightreservation.entities.Reservation;
import com.jun.flightreservation.repos.FlightRepository;
import com.jun.flightreservation.repos.PassengerRepository;
import com.jun.flightreservation.repos.ReservationRepository;

@Service
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
        Long flightId = request.getFlightId();
        Flight flight = flightRepository.findById(flightId).get();
        
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        Passenger savedPassenger = passengerRepository.save(passenger);
        
        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);
        
        return savedReservation;
    }

}
