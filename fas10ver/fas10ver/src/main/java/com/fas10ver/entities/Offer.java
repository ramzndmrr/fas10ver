package com.fas10ver.entities;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="offers")
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="offer_id")
	private int id;
	
	@Column(name="contract_price")
	private Double contractPrice;
	
	@Column(name="approval_status")
	private boolean approvalStatus;
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="business_id")
	private Business business;

	@ManyToOne
	@JoinColumn(name="textile_id")
	private Textile textile;
}
