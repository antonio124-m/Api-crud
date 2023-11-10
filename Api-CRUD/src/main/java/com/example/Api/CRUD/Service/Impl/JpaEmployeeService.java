package com.example.Api.CRUD.Service.Impl;

import com.example.Api.CRUD.Modal.Employee;
import com.example.Api.CRUD.Repository.JpaEmployeeRepository;
import com.example.Api.CRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


@Qualifier(value = "jpa")

public class JpaEmployeeService implements EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;
    
    @Autowired

    public JpaEmployeeService(JpaEmployeeRepository jpaEmployeeRepository) {
        this.jpaEmployeeRepository = jpaEmployeeRepository;
    }

    @Override
    public Employee addemployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getallEmployee() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findByid(Long id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        jpaEmployeeRepository.deleteById(id);
        return true;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = jpaEmployeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setFirstName(employee.getFirstName());
            updatedEmployee.setLastName(employee.getLastName());
            updatedEmployee.setEmail(employee.getEmail());

            // Save the updated employee back to the repository
            return jpaEmployeeRepository.save(updatedEmployee);
        } else {
            // Handle the case where the employee with the given ID does not exist
            // You can throw an exception or return null, depending on your application's requirements
            return null;
        }
    }

}

