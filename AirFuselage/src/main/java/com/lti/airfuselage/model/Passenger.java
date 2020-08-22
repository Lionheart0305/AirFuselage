package com.lti.airfuselage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {
	
	@Id
	@SequenceGenerator(name = "seq_passenger",allocationSize = 1,initialValue = 10101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_passenger")
	private int passengerId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<Ticket>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Passenger> friends = new ArrayList<Passenger>();

    @Column(name = "passport", unique = true, nullable = false)
    private String passport;
    
}
