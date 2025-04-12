package com.portal.hr_portal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.portal.hr_portal.entities.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,Integer>{
    
    Employee findByEmail(String email);

}
