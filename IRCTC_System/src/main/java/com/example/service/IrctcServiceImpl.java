package com.example.service;

import com.example.entity.Passenger;
import com.example.entity.Train;
import com.example.repository.FoodOrderRepository;
import com.example.repository.PassengerRepository;
import com.example.repository.TrainRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
public class IrctcServiceImpl implements IrctcService{

    @Autowired
   private PassengerRepository passengerRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
   private FoodOrderRepository foodOrderRepository;

    @Override
    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Long countPassengersBySourceAndDestination(String source, String destination, LocalDate date) {
        return passengerRepository.countPassengersBySourceAndDestination(source, destination, date);
    }

    @Override
    public Long countFemalePassengersByAgeAndDestination(Long start, Long end, String destination) {
        return passengerRepository.countFemalePassengersByAgeAndDestination(start,end,destination);
    }

    @Override
    public Double getTotalFoodOrderPrice(Long trainId, LocalDate date) {
        return foodOrderRepository.getTotalFoodOrderPrice(trainId,date);
    }


}
