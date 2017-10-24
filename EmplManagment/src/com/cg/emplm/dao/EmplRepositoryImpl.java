package com.cg.emplm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.emplm.dtos.Employee;

@Repository
@Transactional
public class EmplRepositoryImpl implements EmplRepository {

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public List<Employee> getAllItems() {		
		TypedQuery<Employee> query = entityManager.createQuery("SELECT emp FROM Employee emp", Employee.class);
		return query.getResultList();
	}


	@Override
	public Employee addEmployeeDetails(Employee emp) {
		if(emp!=null){
			entityManager.persist(emp);
		}	
		return emp;
	}


	@Override
	public Employee getEmplpyeeById(long employeeId) {
		
		Employee e = new Employee();
		e = entityManager.find(Employee.class,employeeId);
		System.out.println("in Dao"+e);
		return e;
	}


	@Override
	public Employee updateEmployee(Employee emp) {
		if(emp!=null){
			emp = entityManager.merge(emp);
			entityManager.flush();
		}
		return emp;
	}


	@Override
	public boolean deleteEmployee(int employeeId) {
		
		Employee e = getEmplpyeeById(employeeId);
		entityManager.remove(e);
		
		return true;
	}

	
}
