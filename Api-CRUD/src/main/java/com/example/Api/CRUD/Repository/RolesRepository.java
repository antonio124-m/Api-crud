package com.example.Api.CRUD.Repository;

import com.example.Api.CRUD.Modal.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

   // Roles FindByName (String name);

    Roles findByName(String name);

}
