package com.ksr.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloods")
public class Blood {
	
	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public int id;
	@Column(name="name")
	public String name;
	
	@Column(name="age")
	public int age;
	
	@Column(name="DOB")
	public String DOB;
	
	@Column(name="bloodgroup")
	public String bloodgroup;
	
	@Column(name="phoneno")
	public String phoneno;
	
	@Column(name="location")
	public String location;
	
	public Blood() {
		
	}

	public Blood(String name, int age, String dOB, String bloodgroup, String phoneno, String location) {
		super();
		this.name = name;
		this.age = age;
		DOB = dOB;
		this.bloodgroup = bloodgroup;
		this.phoneno = phoneno;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
	

}
