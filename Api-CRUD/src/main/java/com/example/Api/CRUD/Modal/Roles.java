package com.example.Api.CRUD.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity
public class Roles {
    @Id
    @GeneratedValue

    private  Long  id;
    private  String code;
    private  String  name;


    public Roles(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Roles() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
