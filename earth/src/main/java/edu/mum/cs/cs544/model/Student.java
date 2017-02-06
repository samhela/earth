package edu.mum.cs.cs544.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int id;
	
	private String studentId;
	private String firstname;
	private String lastname;
	private String barcode;
	

}
