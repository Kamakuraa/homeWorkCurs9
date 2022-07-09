package com.example.hoteladmin.repository;

import com.example.hoteladmin.model.entity.CleaningProcedure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CleaningProcedureRepository extends MongoRepository<CleaningProcedure, String> {
}
