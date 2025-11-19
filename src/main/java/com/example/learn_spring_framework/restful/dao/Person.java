package com.example.learn_spring_framework.restful.dao;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-19 20:01
 */
public class Person {
    private String name;
    private String firstName ;
    private String secondName ;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
