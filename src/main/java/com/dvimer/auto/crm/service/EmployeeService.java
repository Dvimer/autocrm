package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.entity.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> findAll();

     Employee findById(int theId);

     void save(Employee theEmployee);

     void deleteById(int theId);

}
