package com.jun.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${com.jun.flightreservation.itinerary.dirpath}")
    private String ITINERARY_DIR;

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
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
    
    @Override
    public Reservation bookFlight(ReservationRequest request) {
        
        LOGGER.info("Inside bookFlight()");
        // Make Payment through a third party software
        
        Long flightId = request.getFlightId();
        LOGGER.info("Fetching flight for flight id: " + flightId);
        Flight flight = flightRepository.findById(flightId).get();
        
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        LOGGER.info("Saving the passenger: " + passenger);
        Passenger savedPassenger = passengerRepository.save(passenger);
        
        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        
        LOGGER.info("Saving the reservation: " + reservation);
        Reservation savedReservation = reservationRepository.save(reservation);
        
        String filePath = ITINERARY_DIR 
                + savedReservation.getId() + ".pdf";
        LOGGER.info("Generating the itinerary");
        pdfGenerator.generateItinerary(savedReservation, filePath);
        LOGGER.info("Emailing the itinerary");
        emailUtil.sendItinerary(passenger.getEmail(), filePath);
        
        return savedReservation;
    }

}
