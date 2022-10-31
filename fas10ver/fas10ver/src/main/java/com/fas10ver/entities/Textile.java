package com.fas10ver.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="textiles")
public class Textile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="textile_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@JsonIgnore
	@OneToMany(mappedBy = "textile")
	private List<Employee> employes;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "textile")
	private List<Business> businesses;
	
	
	@JsonIgnore
	@OneToMany(mappedBy ="textile" )
	private List<Offer> offers;
	
	
	
}
