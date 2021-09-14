package com.pairlearning.expensetracker.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pet")
public class Pet implements Serializable{

	
	Integer uid;
	String name;
//	@Temporal(TemporalType.DATE)
//	@Column(name="birth")
	java.sql.Date birth = (java.sql.Date) new Date();
	String breed;
	String kind;
	Timestamp added;
	Timestamp updated;
	String img;
}
