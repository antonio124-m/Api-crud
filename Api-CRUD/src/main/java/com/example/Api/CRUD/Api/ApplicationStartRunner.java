package com.example.Api.CRUD.Api;

import com.example.Api.CRUD.Modal.Roles;
import com.example.Api.CRUD.Repository.RolesRepository;
import com.sun.source.util.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service

public class ApplicationStartRunner implements CommandLineRunner {


    private final RolesRepository rolesRepository;
   @Autowired
    public ApplicationStartRunner(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }






    @Override
    public void run(String... args) throws Exception {
        Roles roleUser = new Roles(1L, "123", "ROLE_USER");
        Roles roleAdmin = new Roles(2L, "456", "ROLE_ADMIN");
        rolesRepository.saveAll(Arrays.asList(roleUser,roleAdmin));

    }
}
