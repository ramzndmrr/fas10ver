package com.fas10ver.entities;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="businesses")
@AllArgsConstructor
@NoArgsConstructor
public class Business {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="business_id")
	private int id;
	
	@Column(name="category")
	private String category;
	
	@Column(name="type")
	private String type;
	
	@Column(name="piece")
	private int piece;
	
	@Column(name="contract_price")
	private Double contractPrice;
	
	@Column(name="description")
	private String description;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;
	
	
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;

	
	@ManyToOne
	@JoinColumn(name = "textile_id")
	private Textile textile;
	
	//@Jsonignore
	@OneToMany(mappedBy = "business")
	private List<Offer> offers;
}
