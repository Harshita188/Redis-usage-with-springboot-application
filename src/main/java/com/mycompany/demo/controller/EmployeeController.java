package com.mycompany.demo.controller;

import com.mycompany.demo.model.Employee;
import com.mycompany.demo.service.EmployeeService;
import com.mycompany.demo.service.RedisAccessService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RedisAccessService redisAccessService;

    // Get employee - will cache on first call
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    // Update employee - will update the cache
    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Get employee directly from Redis using RedisTemplate
    @GetMapping("/redis/{id}")
    public Employee getEmployeeFromRedis(@PathVariable Long id) {
        return redisAccessService.getEmployeeFromRedis(id);
    }
    // Get all employees from Redis
@GetMapping("/redis")
public List<Employee> getAllEmployeesFromRedis() {
    return redisAccessService.getAllEmployeesFromRedis();
}

}
