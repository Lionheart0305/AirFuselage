package com.lti.airfuselage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "price_list")
public class PriceList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int priceId;

	@Column
	private Double businessClassPrice;

	@Column
	private Double economyClassPrice;

	@Column
	private Double firstClassPrice;

}
