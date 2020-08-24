package com.lti.airfuselage.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lti.airfuselage.enumeration.SeatClass;

@Entity
@Table(name = "seat")
public class Seat {

	@Id
	@SequenceGenerator(name = "seq_seat",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_seat")
	private int seatId;

	@Column
	private int rowValue;

	@Column
	private int columnValue;
	
	@Column
	private SeatClass seatClass;
	
	@OneToOne(mappedBy = "seat",cascade = CascadeType.ALL)
	private Ticket ticket;
		
}
