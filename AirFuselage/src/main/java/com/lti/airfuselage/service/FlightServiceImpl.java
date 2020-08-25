package com.lti.airfuselage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.airfuselage.exception.FlightServiceException;
import com.lti.airfuselage.model.Flight;
import com.lti.airfuselage.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepo;

	@Override
	public void add(Flight flight) {
		if(!flightRepo.isFlightPresent(flight.getFlightId())) {
			flightRepo.add(flight);
		}
		else
			throw new FlightServiceException("Flight already exists");
	}

	@Override
	public List<Flight> viewRespectiveFlights(String Source, String Destination) {
		return flightRepo.viewRespectiveFlights(Source, Destination);
	}

	@Override
	public Flight updateFlight(Flight flight) {
		return flightRepo.updateFlight(flight);
	}

	@Override
	public boolean deleteFlight(int flightId) {
		if(flightRepo.isFlightPresent(flightId)) {
			flightRepo.deleteFlight(flightId);
		}
		else
			throw new FlightServiceException("Flight deleted exists");
		return false;
	}

	@Override
	public Flight findAFlight(int flightNumber) {
		
		return flightRepo.findAFlight(flightNumber);
	}
	
	@Override
	public List<Flight> findAll() {
		return flightRepo.findAll();
	}


	
}
