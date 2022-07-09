package com.example.hoteladmin.controller;

import com.example.hoteladmin.exception.ResourceNotFoundException;
import com.example.hoteladmin.model.entity.CleaningProcedure;
import com.example.hoteladmin.model.entity.Review;
import com.example.hoteladmin.model.entity.Room;
import com.example.hoteladmin.service.CleaningProcedureService;
import com.example.hoteladmin.service.ReviewService;
import com.example.hoteladmin.service.RoomService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rooms")
public class RoomController {
  private final RoomService service;
  private final ReviewService reviewService;
  private final CleaningProcedureService cleaningProcedureService;

  @GetMapping
  Page<Room> getAll() {
    return service.getAll();
  }

  @GetMapping("{roomId}")
  Room getRoom(@PathVariable String roomId) {
    return service.getRoom(roomId)
      .orElseThrow(() -> new ResourceNotFoundException("Cannot find room with ID: " + roomId));
  }

  @GetMapping("{roomId}/cleanups")
  List<CleaningProcedure> getRoomCleanups(@PathVariable String roomId) {
    return cleaningProcedureService.getRoomCleanups(roomId);
  }

  @GetMapping("{roomId}/reviews")
  List<Review> getRoomReviews(@PathVariable String roomId) {
    return reviewService.getRoomReviews(roomId);
  }

  @PatchMapping("{roomId}")
  Room patchRoom(@RequestBody JsonPatch patch, @PathVariable String roomId) {
    return service.patchRoom(roomId, patch);
  }

  @DeleteMapping("{roomId}")
  Room deleteRoom(@PathVariable String roomId) {
    return service.deleteRoom(roomId);
  }
}
