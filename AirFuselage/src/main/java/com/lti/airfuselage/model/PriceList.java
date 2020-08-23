package com.lti.airfuselage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "price_list")
public class PriceList {

	@Id
	@SequenceGenerator(name = "seq_pricelist",allocationSize = 1,initialValue = 10101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pricelist")
	private int priceId;

	@Column
	private Double businessClassPrice;

	@Column
	private Double economyClassPrice;

	@Column
	private Double firstClassPrice;

}
