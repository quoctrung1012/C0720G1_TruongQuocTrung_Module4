package com.codegym.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class User {

    @NotEmpty
    @Size(min = 2, max = 60)
    private String name;

    @Min(18)
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
