package com.example.demo.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee extends BaseDomain {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary", columnDefinition = "double")
    @NotNull
    private double salary;

    public Employee(Long id, boolean isActive, Date createDate, Date updateDate, String name, double salary) {
        super(id, isActive, createDate, updateDate);
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
