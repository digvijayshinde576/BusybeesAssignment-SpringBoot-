package com.example.service;
import com.example.entity.Boss;
import com.example.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceEmployeeBoss {
    Employee addEmployee(Employee employee);
    Boss addBoss(Boss boss);
    List<Employee> findByAgeAndRating(int age,double rating);
    void updateBossSalary(double rating,double increment);
    long countOfEmployee(double empRating,double bossRating);
}
