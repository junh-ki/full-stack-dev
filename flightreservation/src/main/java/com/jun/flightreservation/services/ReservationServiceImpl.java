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
import com.jun.flightreservation.util.EmailUtil;
import com.jun.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private FlightRepository flightRepository;
    
    @Autowired
    private PassengerRepository passengerRepository;
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private PDFGenerator pdfGenerator;
    
    @Autowired
    private EmailUtil emailUtil;
    
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
        
        String filePath = "/home/junh-ki/Desktop/full-stack-dev/reservationPDFs/reservation" 
                + savedReservation.getId() + ".pdf";
        pdfGenerator.generateItinerary(savedReservation, filePath);
        emailUtil.sendItinerary(passenger.getEmail(), filePath);
        
        return savedReservation;
    }

}
