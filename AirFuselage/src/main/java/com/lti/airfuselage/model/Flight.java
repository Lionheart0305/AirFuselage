package com.lti.airfuselage.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@SequenceGenerator(name = "seq_flight", allocationSize = 1, initialValue = 20201)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_flight")
	private int flightId;

	@Column
	private LocalDateTime departureTime;

	@Column
	private LocalDateTime arrivalTime;

	@Column
	private String Source;

	@Column
	private String Destination;

	@Column
	private int seatCapacity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flight", cascade = CascadeType.ALL)
	private List<Ticket> tickets = new ArrayList<Ticket>();

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", Source=" + Source + ", Destination=" + Destination + "]";
	}

}
