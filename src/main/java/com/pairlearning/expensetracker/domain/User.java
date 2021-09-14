package com.pairlearning.expensetracker.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User implements Serializable{

	@Id
	Timestamp updated;
	Boolean sex;
	String phone;
	String name;
	String img;
	Timestamp created;
	String address;
	String password;
	Integer id;
	Boolean role;
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "user")
//	List<Order> orders;
	
	

   
}
