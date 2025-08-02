package com.nec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentEntity {

    @Id
    private int rollNumber;

    private String name;

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
