package com.aqdamnaseem.projects.employee.management.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aqdamnaseem.projects.employee.management.dto.EmployeeDTO;
import com.aqdamnaseem.projects.employee.management.mapper.AddressMapper;
import com.aqdamnaseem.projects.employee.management.mapper.EmployeeMapper;
import com.aqdamnaseem.projects.employee.management.model.Employee;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {

	@Autowired
	private AddressMapper addressMapper;

	@Override
	public EmployeeDTO mapToDto(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee mapToDomain(EmployeeDTO addressDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
