package com.example.learn_spring_framework.restful.dao;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-17 18:57
 */
public class User {

    //@Min(1)
    private Integer id;
    @Size(min=2, max=10)
    private String name;
    @Past
    private LocalDate birthDate;

    public User(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
