package com.example.controller;

import com.example.entity.Citizen;
import com.example.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @PostMapping
    public ResponseEntity<?> addCitizen(@RequestBody Citizen citizen){
        return new ResponseEntity<>(citizenService.addCitizen(citizen), HttpStatus.CREATED);
    }

    @GetMapping("/byAadhar/{aadharId}")
    public ResponseEntity<?> findCitizenByAadharId(@PathVariable Long aadharId){
        return new ResponseEntity<>(citizenService.findCitizenByAadharId(aadharId),HttpStatus.FOUND);
    }

    @GetMapping("/byPan/{panId}")
    public ResponseEntity<?> findCitizenByPanId(@PathVariable Long panId){
        return new ResponseEntity<>(citizenService.findCitizenByAadharId(panId),HttpStatus.FOUND);
    }

    @PutMapping("/updateName/{aadharId}")
    public ResponseEntity<?> updateCitizenByAadharId(@PathVariable Long aadharId,@RequestBody String name){
       if (citizenService.updateCitizenByAadharId(aadharId,name))
           return ResponseEntity.ok("Citizen is Updated SuccessFully.....");

       return  ResponseEntity.badRequest().body("Aadhar is not valid....");
    }



}
