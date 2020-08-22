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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flight", cascade = CascadeType.ALL)
	private List<Ticket> tickets = new ArrayList<Ticket>();

}
