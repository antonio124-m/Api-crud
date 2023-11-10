package com.example.Api.CRUD.Service.Impl;

import com.example.Api.CRUD.Modal.Employee;
import com.example.Api.CRUD.Repository.MemoryEmployeeRepository;
import com.example.Api.CRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

@Qualifier(value = "Memory")

public class MemoryEmployeeServiceImpl implements EmployeeService {
    private final MemoryEmployeeRepository memoryEmployeeRepository;

    @Autowired
    public MemoryEmployeeServiceImpl(MemoryEmployeeRepository memoryEmployeeRepository) {
        this.memoryEmployeeRepository = memoryEmployeeRepository;
    }



    @Override
    public Employee addemployee(Employee employee) {
         return  memoryEmployeeRepository.addemployee(employee);

    }

    @Override
    public List<Employee> getallEmployee() {
        return memoryEmployeeRepository.getallEmployee();
    }


    @Override
    public Employee findByid(Long id) {

        return memoryEmployeeRepository.findById(id);
    }



    @Override
    public Boolean deleteEmployee(Long id) {
        return memoryEmployeeRepository.deleteEmployee(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        memoryEmployeeRepository.updateEmployee(employee);
        return employee;

    }
}
