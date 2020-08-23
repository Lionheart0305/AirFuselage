package com.lti.airfuselage.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "system_admin")
public class SystemAdmin {

	@Id
	@SequenceGenerator(name = "seq_admin", initialValue = 20001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_admin")
	private int id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private String confirmPassword;

	@Column
	private LocalDate dateOfBirth;

	@Column
	private String mobileNumber;
	
}