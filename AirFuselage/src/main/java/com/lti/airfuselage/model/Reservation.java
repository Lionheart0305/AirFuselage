package com.lti.airfuselage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@SequenceGenerator(name = "seq_reservation", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reservation")
	private int reservationId;

	@OneToOne
	@JoinColumn(name = "ticket")
	private Ticket ticket;

	@OneToOne
	@JoinColumn(name = "passenger")
	private Passenger passenger;

	@Column
	private Date reservationDate;

}
