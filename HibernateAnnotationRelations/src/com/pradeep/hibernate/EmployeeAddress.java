package com.pradeep.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Table(name="pc_employee_address")
@Entity

public class EmployeeAddress {
	
    @Id
   // @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    
    @Column(unique=true,nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property",value="employee"))
    private int empid;
	
    
    
    private String address;
	private String country;
	
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;
	
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
