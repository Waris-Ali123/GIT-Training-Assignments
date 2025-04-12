package com.portal.hr_portal.services;

import org.springframework.http.ResponseEntity;

import com.portal.hr_portal.entities.Employee;

public interface EmployeeService {
    
    ResponseEntity<?> getAllEmployees();
    
    ResponseEntity<?> addEmployee(Employee emp);

    ResponseEntity<?> updateEmployee(int id, Employee emp);

    ResponseEntity<?> deleteEmployee(int id);

    ResponseEntity<?> login(String email, String name);

}
