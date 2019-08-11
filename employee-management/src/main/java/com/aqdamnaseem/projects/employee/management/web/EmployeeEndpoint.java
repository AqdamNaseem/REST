package com.aqdamnaseem.projects.employee.management.web;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.aqdamnaseem.projects.employee.management.dto.EmployeeDTO;
import com.aqdamnaseem.projects.employee.management.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeEndpoint extends BaseEndpoint {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Return all instances of Employee
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		List<EmployeeDTO> employees = employeeService.findAll();
		return ResponseEntity.ok().body(employees);
	}

	/**
	 * Retrieves an Employee by its id.
	 * 
	 * @return
	 */
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable("employeeId") String employeeId) {
		EmployeeDTO employee = employeeService.findById(employeeId);
		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(employee);
	}

	/**
	 * Saves a given Employee record
	 * 
	 * @return
	 */
	@PostMapping
	public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO employee, UriComponentsBuilder uriBuilder) {
		EmployeeDTO createdEmployee = employeeService.create(employee);
		UriComponents uriComponents = uriBuilder.path("/employees/{id}")
				.buildAndExpand(createdEmployee.getEmployeeId());
		return ResponseEntity.created(uriComponents.toUri()).body(createdEmployee);
	}

	/**
	 * Updates a given Employee record
	 * 
	 * @return
	 */
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable("employeeId") String employeeId,
			@RequestBody EmployeeDTO employee) {
		EmployeeDTO updatedEmployee = employeeService.update(employeeId, employee);
		return ResponseEntity.accepted().body(updatedEmployee);
	}

	/**
	 * Deletes the Employee record with the given id.
	 * 
	 * @return
	 */
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Void> delete(@PathVariable("employeeId") String employeeId) {
		employeeService.delete(employeeId);
		return ResponseEntity.noContent().build();
	}

}
