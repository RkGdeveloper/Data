package com.cg.emplm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.emplm.dao.EmplRepository;
import com.cg.emplm.dtos.Employee;

@Service
public class EmplServiceImpl implements EmplService {

	@Autowired
	private EmplRepository empRepository;
	public EmplRepository getEmpRepository() {
		return empRepository;
	}
	public void setEmpRepository(EmplRepository empRepository) {
		this.empRepository = empRepository;
	}
	@Override
	public List<Employee> getAllItems() {
		return empRepository.getAllItems();
	}
	@Override
	public Employee addEmployeeDetails(Employee emp) {
		return empRepository.addEmployeeDetails(emp);
	}
	@Override
	public Employee getEmpById(long employeeId) {
		return empRepository.getEmplpyeeById(employeeId);
	}
	@Override
	public Employee updateEmployee(Employee emp) {
		return empRepository.updateEmployee(emp);
	}
	@Override
	public boolean delete(int employeeId) {
		return empRepository.deleteEmployee(employeeId);
	}
}
