package com.dvimer.auto.crm.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvimer.auto.crm.dao.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	 List<Employee> findAllByOrderByLastNameAsc();
	
}
