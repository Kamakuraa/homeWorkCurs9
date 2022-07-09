package com.example.hoteladmin.service;

import com.example.hoteladmin.exception.ResourceNotFoundException;
import com.example.hoteladmin.model.entity.CleaningProcedure;
import com.example.hoteladmin.model.entity.Cleanup;
import com.example.hoteladmin.model.entity.Review;
import com.example.hoteladmin.repository.CleaningProcedureRepository;
import com.example.hoteladmin.repository.CleanupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CleaningProcedureService {
  private final CleaningProcedureRepository repository;
  private final CleanupRepository cleanupRepository;

  public List<CleaningProcedure> getRoomCleanups(String roomId) {
    return repository.findAll().stream()
      .filter(procedure -> getOrThrow(procedure.getCleanupId()).getRoomId().equalsIgnoreCase(roomId))
      .collect(Collectors.toList());
  }

  private Cleanup getOrThrow(String id) {
    return cleanupRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException ("Could not find cleanup"));
  }
}
