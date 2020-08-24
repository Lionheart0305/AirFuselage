package com.lti.airfuselage.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airfuselage.controller.FlightControllerImpl.Status.StatusType;
import com.lti.airfuselage.exception.FlightServiceException;
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
