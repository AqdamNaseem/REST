package com.aqdamnaseem.projects.employee.management.service;

import java.util.List;

import com.aqdamnaseem.projects.employee.management.dto.EmployeeDTO;
import com.aqdamnaseem.projects.employee.management.model.Employee;

/**
 * @author aqdamnaseem
 *
 */
public interface EmployeeService {

	/**
	 * Find all {@link Employee}
	 * 
	 * @return
	 */
	public List<EmployeeDTO> findAll();

	/**
	 * Find {@link Employee} by Employee Id
	 * 
	 * @param employeeId
	 * @return
	 */
	public EmployeeDTO findById(String employeeId);

	/**
	 * Create new {@link Employee} record
	 * 
	 * @param employee
	 * @return
	 */
	public EmployeeDTO create(EmployeeDTO employee);

	/**
	 * Update an {@link Employee} record
	 * 
	 * @param employeeId
	 * @param employee
	 * @return
	 */
	public EmployeeDTO update(String employeeId, EmployeeDTO employee);

	/**
	 * Delete an {@link Employee} record
	 * 
	 * @param employeeId
	 */
	public void delete(String employeeId);

}
