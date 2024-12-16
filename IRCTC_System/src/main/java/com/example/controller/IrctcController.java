package com.example.controller;

import com.example.entity.Passenger;
import com.example.entity.Train;
import com.example.service.IrctcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/irctc")
public class IrctcController {
    @Autowired
    private IrctcService irctcService;

    @PostMapping("/addTrain")
    public ResponseEntity<?> addTrain(@RequestBody Train train){
        return new ResponseEntity<>(irctcService.addTrain(train), HttpStatus.CREATED);
    }

    @PostMapping("/addPassenger")
    public ResponseEntity<?> addPassenger(@RequestBody Passenger passenger){
        return new ResponseEntity<>(irctcService.addPassenger(passenger), HttpStatus.CREATED);
    }

    @GetMapping("/passengerCount")
    public Long countPassengersBySourceAndDestination(@RequestParam String source, @RequestParam String destination, @RequestParam LocalDate date){
        return irctcService.countPassengersBySourceAndDestination(source, destination, date);
    }

    @GetMapping("/femaleCount")
    public ResponseEntity<?> countFemalePassengersByAgeAndDestination(@RequestParam Long start, @RequestParam Long end,@RequestParam String destination) {
        return ResponseEntity.ok(irctcService.countFemalePassengersByAgeAndDestination(start,end,destination));
    }

    @GetMapping("/totalFoodPrice")
    public ResponseEntity<?> getTotalFoodOrderPrice(@RequestParam Long trainId,@RequestParam LocalDate date) {
        return ResponseEntity.ok(irctcService.getTotalFoodOrderPrice(trainId,date));
    }

}
