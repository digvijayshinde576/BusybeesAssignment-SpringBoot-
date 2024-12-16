package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private int age;
        private double rating;

        @JsonIgnore
        @ManyToOne
        private Boss boss;

        public Employee() {
        }

        public Employee(Long id, String name, int age, double rating, Boss boss) {
                this.id = id;
                this.name = name;
                this.age = age;
                this.rating = rating;
                this.boss = boss;
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

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public double getRating() {
                return rating;
        }

        public void setRating(double rating) {
                this.rating = rating;
        }

        public Boss getBoss() {
                return boss;
        }

        public void setBoss(Boss boss) {
                this.boss = boss;
        }

        @Override
        public String toString() {
                return "Employee{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", age=" + age +
                        ", rating=" + rating +
                        ", boss=" + boss +
                        '}';
        }
}


