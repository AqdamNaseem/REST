package com.aqdamnaseem.projects.employee.management.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqdamnaseem.projects.employee.management.common.Constants;
import com.aqdamnaseem.projects.employee.management.dto.AddressDTO;
import com.aqdamnaseem.projects.employee.management.dto.EmployeeDTO;
import com.aqdamnaseem.projects.employee.management.exception.ApplicationException;
import com.aqdamnaseem.projects.employee.management.exception.EmployeeNotFoundException;
import com.aqdamnaseem.projects.employee.management.exception.ResourceNotFoundException;
import com.aqdamnaseem.projects.employee.management.mapper.AddressMapper;
import com.aqdamnaseem.projects.employee.management.mapper.EmployeeMapper;
import com.aqdamnaseem.projects.employee.management.model.Employee;
import com.aqdamnaseem.projects.employee.management.repository.AddressRepository;
import com.aqdamnaseem.projects.employee.management.repository.EmployeeRepository;
import com.aqdamnaseem.projects.employee.management.service.EmployeeService;

/**
 * @author aqdamnaseem
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Transactional(readOnly = true)
	@Override
	public List<EmployeeDTO> findAll() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		return employees.stream().map(employeeMapper::mapToDto).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public EmployeeDTO findById(String employeeId) {
		Employee employee = employeeRepository.findByEmployeeId(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException());
		EmployeeDTO employeeDTO = employeeMapper.mapToDto(employee);
		return employeeDTO;
	}

	@Override
	public EmployeeDTO create(EmployeeDTO employeeDTO) {
		Employee employee = employeeMapper.mapToDomain(employeeDTO);
		employeeRepository.save(employee);
		return employeeDTO;
	}

	@Override
	public EmployeeDTO update(String employeeId, EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findByEmployeeId(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException());
		employeeRepository.save(employee);
		return employeeDTO;
	}

	@Override
	public void delete(String employeeId) {
		Employee employee = employeeRepository.findByEmployeeId(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException());
		employeeRepository.delete(employee);
	}

}
