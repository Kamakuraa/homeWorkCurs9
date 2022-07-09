package com.example.hoteladmin.repository;

import com.example.hoteladmin.model.entity.Cleanup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CleanupRepository extends MongoRepository<Cleanup, String> {
}
