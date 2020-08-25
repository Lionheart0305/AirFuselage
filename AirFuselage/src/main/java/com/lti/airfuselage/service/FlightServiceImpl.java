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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFlight(int flightNumber) {
		if(flightRepo.isFlightPresent(flightNumber)) {
			flightRepo.deleteFlight(flightNumber);
		}
		else
			throw new FlightServiceException("Flight deleted exists");
		return false;
	}

	@Override
	public Flight findAFlight(int flightNumber) {
		
		return flightRepo.findAFlight(flightNumber);
	}


	
}
