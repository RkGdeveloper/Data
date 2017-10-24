package com.cg.emplm.dao;

import java.util.List;

import com.cg.emplm.dtos.Employee;

public interface EmplRepository {
	List<Employee> getAllItems();

	Employee addEmployeeDetails(Employee emp);

	Employee getEmplpyeeById(long employeeId);

	Employee updateEmployee(Employee emp);

	boolean deleteEmployee(int employeeId);
}
