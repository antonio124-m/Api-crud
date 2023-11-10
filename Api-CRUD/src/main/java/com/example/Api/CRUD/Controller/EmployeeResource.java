package com.example.Api.CRUD.Controller;


import com.example.Api.CRUD.Modal.Employee;
import com.example.Api.CRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/employee")


public class EmployeeResource {


    private final EmployeeService employeeService;
   @Autowired
    public EmployeeResource(@Qualifier(value = "jpa")
                               EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping
    public ResponseEntity<List<Employee>>getallEmployee(){
       return ResponseEntity.ok(employeeService.getallEmployee());
    }


    @GetMapping("{id}")
    public ResponseEntity<Employee>getEmployee(@PathVariable("id") Long id ){
        return ResponseEntity.ok(employeeService.findByid(id));
    }


    @PostMapping("/add")
    public ResponseEntity<Employee> addemployee(@RequestBody Employee employee) {
        Employee addedEmployee = employeeService.addemployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee( id, employee);

        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
        Boolean deletedEmployee = employeeService.deleteEmployee(id);

        if (deletedEmployee != null) {
            return ResponseEntity.ok(deletedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
