package com.cg.emplm.service;

import java.util.List;

import com.cg.emplm.dtos.Employee;

public interface EmplService {
	List<Employee> getAllItems();

	Employee addEmployeeDetails(Employee emp);

	Employee getEmpById(long employeeId);

	Employee updateEmployee(Employee emp);

	boolean delete(int employeeId);
}
