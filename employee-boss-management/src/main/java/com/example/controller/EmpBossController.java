package com.example.controller;

import com.example.entity.Boss;
import com.example.entity.Employee;
import com.example.service.ServiceEmployeeBoss;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empBoss")
@RequiredArgsConstructor
public class EmpBossController {


    private ServiceEmployeeBoss serviceEmployeeBoss;

    public EmpBossController(ServiceEmployeeBoss serviceEmployeeBoss) {
        this.serviceEmployeeBoss = serviceEmployeeBoss;
    }

    @PostMapping("/emp")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(serviceEmployeeBoss.addEmployee(employee),HttpStatus.CREATED);
    }

    @PostMapping("/boss")
    public ResponseEntity<?> addBoss(@RequestBody Boss boss){
        return new ResponseEntity<>(serviceEmployeeBoss.addBoss(boss),HttpStatus.CREATED);
    }

    @GetMapping("/{age}/{rating}")
    public List<Employee> findByAgeAndRating(@PathVariable int age, @PathVariable double rating) {
        return serviceEmployeeBoss.findByAgeAndRating(age,rating);
    }

    @PutMapping("/updateSalary")
    public String updateBossSalary(@RequestParam double rating,@RequestParam double increament){
        serviceEmployeeBoss.updateBossSalary(rating,increament);
        return "Salary Upadated Successfully...";
    }


    @GetMapping("/empCount")
    public long countOfEmployee(@RequestParam double empRating, @RequestParam double bossRating) {
        return serviceEmployeeBoss.countOfEmployee(empRating,bossRating);
    }

}
