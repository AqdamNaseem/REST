package com.aqdamnaseem.projects.employee.management.repository.common;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {

	/**
	 * @param id
	 * @return
	 */
	Optional<T> findOne(ID id);

}
