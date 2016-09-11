package com.sample.repo;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.domain.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee,Long>{

	Employee findByName(String string);

	Employee findByEmpId(Long empId);

	Employee findByEmpId(String emp);

	void delete(String emp);
	
}
