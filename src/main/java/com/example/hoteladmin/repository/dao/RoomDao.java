package com.example.hoteladmin.repository.dao;

import com.example.hoteladmin.model.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
@RequiredArgsConstructor
public class RoomDao {
  private final MongoTemplate mongo;

  public Page<Room> findRooms() {
    Criteria criteria = Criteria.where ("RoomNumber").regex (".*A*");

    Query query = Query.query (criteria);

    PageRequest pageable = PageRequest.of (0, 2, Sort.by ("roomNumber"));
    query.with (pageable);
    List<Room> rooms = mongo.find (
      query,
      Room.class);
    return PageableExecutionUtils.getPage (
      rooms,
      pageable,
      () -> mongo.count (Query.query (criteria), Room.class));

  }
}
