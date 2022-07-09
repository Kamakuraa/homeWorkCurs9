package com.example.hoteladmin.repository;

import com.example.hoteladmin.model.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
  List<Review> findAllByRoomId(String roomId);
}
