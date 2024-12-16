package com.example.service;

import com.example.entity.Boss;
import com.example.entity.Employee;
import com.example.repository.BossRepository;
import com.example.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ServiceEmployeeBossImpl implements ServiceEmployeeBoss{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BossRepository  bossRepository;
    @Override
    public Employee addEmployee(Employee employee) {
       return employeeRepository.save(employee);

    }

    @Override
    public Boss addBoss(Boss boss) {
        return bossRepository.save(boss);
    }

    @Override
    public List<Employee> findByAgeAndRating(int age, double rating) {
        return employeeRepository.findByAgeLessThanAndRatingGreaterThan(age,rating);
    }

    @Override
    public void updateBossSalary(double rating, double increment) {
        List<Boss> bossList = bossRepository.findByRatingGreaterThan(rating);
        for(Boss boss:bossList){
            boss.setSalary(boss.getSalary()+increment);
            bossRepository.save(boss);
        }
    }

    @Override
    public long countOfEmployee(double empRating, double bossRating) {
        return employeeRepository.countByRatingGreaterThanAndBoss_RatingGreaterThan(empRating,bossRating);
    }


}
