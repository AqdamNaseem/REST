package com.aqdamnaseem.projects.employee.management.mapper;

import com.aqdamnaseem.projects.employee.management.dto.AddressDTO;
import com.aqdamnaseem.projects.employee.management.model.Address;

public interface AddressMapper {

	/**
	 * @param address
	 * @return
	 */
	AddressDTO mapToDto(Address address);

	/**
	 * @param addressDTO
	 * @return
	 */
	Address mapToDomain(AddressDTO addressDTO);

}
