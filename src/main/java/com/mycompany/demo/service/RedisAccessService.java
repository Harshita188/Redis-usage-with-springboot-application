package com.mycompany.demo.service;

import com.mycompany.demo.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

@Service
public class RedisAccessService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    // public Employee getEmployeeFromRedis(Long id) {
    //     return (Employee) redisTemplate.opsForValue().get("employeeCache::" + id);
    // }
    @Value("${spring.cache.redis.key-prefix}")
    private String redisPrefix;

    public Employee getEmployeeFromRedis(Long id) {
       
        String key = redisPrefix + "employeeCache::" + id;
        Object value = redisTemplate.opsForValue().get(key);

       System.out.println("Redis value for key " + key + ": " + value);

if (value != null) {
    System.out.println("Class: " + value.getClass());
    // Proceed with logic
} else {
    System.out.println("No value found in Redis for key: " + key);
    // Optionally fetch from DB or handle accordingly
}
        return (Employee) value;
    }
    
    public List<Employee> getAllEmployeesFromRedis() {
    String pattern = redisPrefix + "employeeCache::*";
    List<Employee> employees = new ArrayList<>();

    Cursor<byte[]> cursor = redisTemplate.getConnectionFactory().getConnection()
        .scan(ScanOptions.scanOptions().match(pattern).count(1000).build());

    while (cursor.hasNext()) {
        String key = new String(cursor.next());
        Object value = redisTemplate.opsForValue().get(key);
        if (value instanceof Employee) {
            employees.add((Employee) value);
        }
    }

    return employees;
}
}
