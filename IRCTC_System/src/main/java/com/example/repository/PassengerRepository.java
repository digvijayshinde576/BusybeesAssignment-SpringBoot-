package com.example.repository;

import com.example.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
   // @Query
  // ("SELECT COUNT(p) FROM Passenger p WHERE p.train.source = :source AND p.train.destination = :destination AND p.date = :date")
//    long countPassengersBySourceAndDestination(@Param("source") String source, @Param("destination") String destination, @Param("date") LocalDate date);

    @Query
   ("SELECT COUNT(p) FROM Passenger p WHERE p.train.source = :source AND p.train.destination = :destination AND p.date = :date")
    long countPassengersBySourceAndDestination(@Param("source") String source, @Param("destination") String destination, @Param("date") LocalDate date);

    @Query
    ("SELECT COUNT(p) FROM Passenger p WHERE p.gender='FeMale' AND p.age Between :start AND :end AND p.train.destination= :destination")
    long countFemalePassengersByAgeAndDestination(@Param("start") Long start, @Param("end") Long end, @Param("destination") String destination);


}


