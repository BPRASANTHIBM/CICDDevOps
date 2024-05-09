package com.hrm.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int houseId;
	private String location;
	private String bedroom;
	private double rent;
	private String parking;
	
	@ManyToOne(cascade = CascadeType.MERGE,targetEntity = Owner.class)
	private Owner owner;
	
}
