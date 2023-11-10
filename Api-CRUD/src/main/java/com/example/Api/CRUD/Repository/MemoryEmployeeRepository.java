package com.example.Api.CRUD.Repository;

import com.example.Api.CRUD.Modal.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Repository
public class MemoryEmployeeRepository {

    private static final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1L,"Antonio","mwilu", "antonio@gmail.com"));
        DATABASE.add(new Employee(2L,"john","mwu", "john@gmail.com"));
        DATABASE.add(new Employee(3L,"pius","mu", "pius@gmail.com"));
        DATABASE.add(new Employee(4L,"muuo","mwilu", "muuo@gmail.com"));
    }

    public  Employee addemployee(Employee employee) {
       DATABASE.add(employee);
        return employee;
    }

   public  List<Employee>getallEmployee(){
        return List.copyOf(DATABASE);
    }


   public  Employee findById(Long id) {
        return DATABASE.stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No employee with the given ID found"));
    }




    public void updateEmployee(Employee employee) {
        boolean employeeExists = false;

        for (int i = 0; i < DATABASE.size(); i++) {
            Employee existingEmployee = DATABASE.get(i);
            if (existingEmployee.getId().equals(employee.getId())) {
                // Update the existing employee with the new employee data
                DATABASE.set(i, employee);
                employeeExists = true;
                break; // Exit the loop once the update is done
            }
        }
//
//       if (!employeeExists) {
//         throw new EmployeeNotFoundException("Employee with ID " + employee.getId() + " not found");
//        }
    }


    public Boolean deleteEmployee(Long id){
        Employee employee=  DATABASE.stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
          DATABASE.remove(employee);
          return Boolean.TRUE;
    }


}
