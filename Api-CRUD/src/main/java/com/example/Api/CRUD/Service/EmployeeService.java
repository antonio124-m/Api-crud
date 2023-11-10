package com.example.Api.CRUD.Service;

import com.example.Api.CRUD.Modal.Employee;

import java.util.List;

public interface EmployeeService {
 public Employee addemployee(Employee employee);// save the employee

  public List<Employee> getallEmployee();// list of all employee


  public Employee findByid(Long id);  // searching with id;



 //public  Employee updateEmployee(Employee employee);

 public  Boolean deleteEmployee(Long id);


  public Employee updateEmployee(Long id, Employee employee);
}
