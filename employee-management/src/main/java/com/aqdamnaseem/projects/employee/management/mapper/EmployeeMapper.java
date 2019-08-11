package com.aqdamnaseem.projects.employee.management.mapper;

import com.aqdamnaseem.projects.employee.management.dto.EmployeeDTO;
import com.aqdamnaseem.projects.employee.management.model.Employee;

public interface EmployeeMapper {

	/**
	 * @param employee
	 * @return
	 */
	EmployeeDTO mapToDto(Employee employee);

	/**
	 * @param addressDTO
	 * @return
	 */
	Employee mapToDomain(EmployeeDTO addressDTO);
}
