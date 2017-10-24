package com.cg.emplm.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empid")
	private Long employeeId;
	
	@NotEmpty(message="Employee FirstName is Required")
	@Size(min = 4,message="FirstName should have atleast 4 character")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty(message="Employee Lastname is Required")
	@Size(min = 6,message="LastName should have atleast 6 character")
	@Column(name="last_name")
	private String lastName;
	
	
	@NotEmpty(message="Employee Designation is Required")
	@Size(min = 10,message="Designation should have atleast 10 character")
	private String designation;
	
	
	@NotNull(message="Salary Required")
//	@Size(min = 1000, message="Salary must be positive")
	private Integer salary;
	
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", designation="
				+ designation + ", salary=" + salary + "]";
	}
	
	
	public Employee(Long employeeId, String firstName, String lastName,
			String designation, Integer salary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.salary = salary;
	}
	public Employee(){}
	
}
