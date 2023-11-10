package com.example.Api.CRUD.Repository;

import com.example.Api.CRUD.Modal.Employee;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Long>{

}
