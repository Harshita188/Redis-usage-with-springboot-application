package com.mycompany.demo.service;

import com.mycompany.demo.model.Employee;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Cacheable(value = "employeeCache", key = "#id")
    public Employee getEmployee(Long id) {
        System.out.println("Fetching from DB...");
        return new Employee(id, "John Doe", "IT");
    }

    // @CachePut(value = "employeeCache", key = "#employee.id")
    // public Employee updateEmployee(Employee employee) {
    // System.out.println("Updating DB and Cache...");
    // return employee;
    // }
    
    @CachePut(value = "employeeCache", key = "#employee.id")
    public Employee updateEmployee(Employee employee) {
        System.out.println("Updating DB and Cache for id: " + employee.getId());
        return employee;
    }
    
}
