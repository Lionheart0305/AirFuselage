package com.lti.airfuselage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@SequenceGenerator(name = "seq_ticket", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ticket")
	private int ticketId;

	@Column
	private double price;

	@ManyToOne
	@JoinColumn(name = "flight")
	private Flight flight;

	@ManyToOne
	@JoinColumn(name = "passenger")
	private Passenger passenger;

	@OneToOne
	@JoinColumn(name = "seat")
	private Seat seat;

	@Column(name = "confirmed", unique = false, nullable = false)
	private Boolean confirmed;

}
