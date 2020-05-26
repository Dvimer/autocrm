package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.repository.EmployeeRepository;
import com.dvimer.auto.crm.dao.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

}






