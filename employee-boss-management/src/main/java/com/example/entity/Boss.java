package com.example.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity

public class Boss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;
    private double rating;

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Boss(double rating, double salary, String name, Long id) {
        this.rating = rating;
        this.salary = salary;
        this.name = name;
        this.id = id;
    }

    public Boss() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", rating=" + rating +
                ", employees=" + employees +
                '}';
    }
}

