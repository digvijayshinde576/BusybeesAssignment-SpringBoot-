package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByAgeLessThanAndRatingGreaterThan(int age, double rating);
    long countByRatingGreaterThanAndBoss_RatingGreaterThan(double empRating,double bossRating);
}
