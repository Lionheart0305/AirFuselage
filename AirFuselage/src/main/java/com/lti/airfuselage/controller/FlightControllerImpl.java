package com.lti.airfuselage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airfuselage.controller.FlightControllerImpl.Status.StatusType;
import com.lti.airfuselage.dto.FlightSearchFilterDto;
import com.lti.airfuselage.exception.FlightServiceException;
import com.lti.airfuselage.exception.InvalidInputException;
import com.lti.airfuselage.exception.ObjectNotFoundException;
import com.lti.airfuselage.model.Flight;
import com.lti.airfuselage.service.FlightService;

@RestController
@CrossOrigin
public class FlightControllerImpl {
	
	@Autowired
	private FlightService flightService;
	
	Status status=new Status();
	
	/*
	 {
    "Source": "Mumbai",
    "Destination": "Kolkata",
    "departureTime":"2021-03-29T13:34:00.000",
    "arrivalTime":"2021-03-29T15:34:00.000"
	}
	 */
	
	@PostMapping("/add")
	private Status add(@RequestBody Flight flight) {
		try {
			flightService.add(flight);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Flight added sucessfully");
			return status;
		}
		catch (FlightServiceException e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	@PostMapping("/delete")
	private @ResponseBody Status deleteFlight(@RequestBody int flightNumber) {
		try {
			flightService.deleteFlight(flightNumber);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Flight deleted sucessfully");
			return status;
		}
		catch (FlightServiceException e) {
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	
	@RequestMapping(value = "/delete/{flightId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable int flightId) {
		Boolean delete = flightService.deleteFlight(flightId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Flight> update(@RequestBody Flight flight) throws ObjectNotFoundException, InvalidInputException {

        Flight updateFlight = flightService.updateFlight(flight);

        return new ResponseEntity<>(updateFlight, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Flight>> getAll() {

        List<Flight> flights = flightService.findAll();

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<List<Flight>> delete(@RequestBody FlightSearchFilterDto dto) {
        try {
		List<Flight> filter = flightService.viewRespectiveFlights(dto.getSource(), dto.getDestination());
        return new ResponseEntity<>(filter, HttpStatus.OK);
        } catch (FlightServiceException e){
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
    }
	
	

	public static class Status {
		private StatusType status;
		private String message;

		public static enum StatusType {
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

}
