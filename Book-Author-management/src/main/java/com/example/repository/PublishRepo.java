package com.example.repository;

import com.example.entity.Publish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishRepo extends JpaRepository<Publish,Long> {
   Long countByAuthor_IdAndPublishYear(Long authorId,int year);
}
