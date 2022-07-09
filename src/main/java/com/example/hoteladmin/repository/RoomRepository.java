package com.example.hoteladmin.repository;

import com.example.hoteladmin.model.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
