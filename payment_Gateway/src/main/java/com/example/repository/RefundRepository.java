package com.example.repository;

import com.example.entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<Refund,Long> {


    @Query(value ="SELECT r.userid FROM Refund r GROUP BY r.userid ORDER BY SUM(r.amount) DESC LIMIT 1",nativeQuery = true)
    Long findUserIdWithMaxRefundAmount();


}
