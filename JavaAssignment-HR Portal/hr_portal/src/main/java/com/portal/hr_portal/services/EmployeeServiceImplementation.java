package com.portal.hr_portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portal.hr_portal.entities.Employee;
import com.portal.hr_portal.repositories.EmployeeRepo;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public ResponseEntity<?> getAllEmployees() {
        try {
            Iterable<Employee> allEmployees = employeeRepo.findAll();
            return ResponseEntity.ok().body(allEmployees);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<?> addEmployee(Employee emp) {
        try {
            Employee employee = employeeRepo.save(emp);
            return ResponseEntity.ok().body(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to add employee");
        }
    }

    @Override
    public ResponseEntity<?> updateEmployee(int id, Employee emp) {
        try {
            Employee existing = employeeRepo.findById(id).orElse(null);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }

            existing.setName(emp.getName());
            existing.setDepartment(emp.getDepartment());
            existing.setEmail(emp.getEmail());
            existing.setSalary(emp.getSalary());
            existing.setRole(emp.getRole());

            Employee updated = employeeRepo.save(existing);
            return ResponseEntity.ok().body(updated);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to update employee");
        }
    }

    @Override
    public ResponseEntity<?> deleteEmployee(int id) {
        try {
            if (!employeeRepo.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            employeeRepo.deleteById(id);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to delete employee");
        }
    }

    @Override
    public ResponseEntity<?> login(String email, String password) {
        try {
            Employee emp = employeeRepo.findByEmail(email);
            if (emp != null && emp.getPassword().equals(password) ) {
                if(emp.getRole().equals(Employee.Role.HR)){
                    return ResponseEntity.ok(emp); 
                }
                else{
                    return ResponseEntity.status(401).body("Only HR can access HR portal");
                }
            } else {
                return ResponseEntity.status(401).body("Invalid email or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Login error");
        }
    }

}
