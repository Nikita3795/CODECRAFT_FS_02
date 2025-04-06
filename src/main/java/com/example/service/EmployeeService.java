package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Save employee
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(String id) {
        return repository.findById(id);
    }

    // Delete employee by ID
    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }
}
