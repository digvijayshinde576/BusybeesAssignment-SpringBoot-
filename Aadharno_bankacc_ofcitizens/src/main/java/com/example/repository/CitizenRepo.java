package com.example.repository;

import com.example.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen,Long> {

//   Optional<Citizen> findByPanno(Long panno);
   @Query("SELECT c FROM Citizen c WHERE c.panno = :panno")
   Optional<Citizen> findByPanno(@Param("panno") Long panno);

}
