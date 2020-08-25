package com.lti.airfuselage.service;

import java.util.List;

import com.lti.airfuselage.model.Flight;

public interface FlightService {
	
	void add(Flight flight);

	List<Flight> viewRespectiveFlights(String Source, String Destination);

	Flight updateFlight(Flight flight);

	Flight findAFlight(int flightId);

	boolean deleteFlight(int flightId);

	List<Flight> findAll();

}
