package com.example.hoteladmin.service;

import com.example.hoteladmin.model.entity.Review;
import com.example.hoteladmin.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
  private final ReviewRepository repository;

  public List<Review> getRoomReviews(String roomId) {
    return repository.findAllByRoomId(roomId);
  }
}
