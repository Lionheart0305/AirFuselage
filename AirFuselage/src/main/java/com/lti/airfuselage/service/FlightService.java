package com.lti.airfuselage.service;

import java.util.List;

import com.lti.airfuselage.model.Flight;

public interface FlightService {
	
	void add(Flight flight);

	List<Flight> viewRespectiveFlights(String Source, String Destination);

	boolean updateFlight(Flight flight);

	Flight findAFlight(int flightNumber);

	boolean deleteFlight(int flightNumber);

}
