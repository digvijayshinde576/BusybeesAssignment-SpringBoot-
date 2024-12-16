package com.example.repository;

import com.example.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {

//    @Query
//    ("SELECT SUM(f.price) FROM FoodOrder f WHERE f.train.trainNo= :trainId AND f.train.passengerList.date= :date")
//    Double getTotalFoodOrderPrice(@Param("trainId") Long trainId, @Param("date") LocalDate date);
//@Query
//        ("SELECT SUM(f.price) FROM FoodOrder f WHERE f.train.trainNo = :trainId AND f.train.passengers.date = :date")
//Double getTotalFoodOrderPrice(@Param("trainId") Long trainId, @Param("date") LocalDate date);

    @Query("SELECT SUM(f.price) FROM FoodOrder f JOIN f.train t JOIN t.passengerList p WHERE t.trainNo = :trainId AND p.date = :date")
    Double getTotalFoodOrderPrice(@Param("trainId") Long trainId, @Param("date") LocalDate date);

}
