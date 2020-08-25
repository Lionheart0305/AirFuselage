package com.lti.airfuselage.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lti.airfuselage.model.Flight;

public interface FlightRepository {

	int add(Flight flight);

	List<Flight> viewRespectiveFlights(String Source, String Destination);

	boolean updateFlight(Flight flight);

	boolean deleteFlight(int flightNumber);

	Flight findAFlight(int flightNumber);
	
	boolean isFlightPresent(int flightNumber);


	

}