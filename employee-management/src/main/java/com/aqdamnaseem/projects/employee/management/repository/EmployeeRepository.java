package com.aqdamnaseem.projects.employee.management.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aqdamnaseem.projects.employee.management.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	/**
	 * @param employeeId
	 * @return
	 */
	Optional<Employee> findByEmployeeId(String employeeId);

}
