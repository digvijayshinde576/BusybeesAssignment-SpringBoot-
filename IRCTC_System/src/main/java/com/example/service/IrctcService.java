package com.example.service;

import com.example.entity.Passenger;
import com.example.entity.Train;
import org.aspectj.weaver.tools.AbstractTrace;

import java.time.LocalDate;

public interface IrctcService {
  Train addTrain(Train train);
  Passenger addPassenger(Passenger passenger);
  Long countPassengersBySourceAndDestination(String source, String destination, LocalDate date);
  Long countFemalePassengersByAgeAndDestination(Long start,Long end,String destination);
  Double getTotalFoodOrderPrice(Long trainId,LocalDate date);
}
