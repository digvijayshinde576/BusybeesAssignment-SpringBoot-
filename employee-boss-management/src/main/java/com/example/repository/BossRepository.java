package com.example.repository;

import com.example.entity.Boss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BossRepository extends JpaRepository<Boss,Long> {
    List<Boss> findByRatingGreaterThan(double rating);
}
