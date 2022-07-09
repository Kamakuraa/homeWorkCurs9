package com.example.hoteladmin.data;

import com.example.hoteladmin.model.entity.*;
import com.example.hoteladmin.repository.CleaningProcedureRepository;
import com.example.hoteladmin.repository.CleanupRepository;
import com.example.hoteladmin.repository.ReviewRepository;
import com.example.hoteladmin.repository.RoomRepository;
import com.example.hoteladmin.service.CleaningProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
  private final RoomRepository roomRepository;
  private final ReviewRepository reviewRepository;
  private final CleaningProcedureRepository cleaningProcedureRepository;
  private final CleanupRepository cleanupRepository;


  @Override
  public void run(String... args) throws Exception {
    final var roomFacilities = List.of (
      new RoomFacilities (true, true),
      new RoomFacilities (true, false),
      new RoomFacilities (false, false),
      new RoomFacilities (false, true)
    );
    final var rooms = List.of (
      new Room ("10", 1, "Rex", roomFacilities.get (0).getId ()),
      new Room ("101", 9, "Hilton", roomFacilities.get (1).getId ()),
      new Room ("130", 12, "Radisson", roomFacilities.get (3).getId ())
    );
    roomRepository.saveAll (rooms);

    final var cleanups = List.of (
      new Cleanup (LocalDate.now ().minusDays (1), rooms.get (0).getId ()),
      new Cleanup (LocalDate.now ().minusDays (10), rooms.get (2).getId ()),
      new Cleanup (LocalDate.now ().minusDays (2), rooms.get (1).getId ())
    );
    cleanupRepository.saveAll (cleanups);

    final var cleaningProcedures = List.of (
      new CleaningProcedure ("Schimbat prosoape", 1, cleanups.get (0).getId ()),
      new CleaningProcedure ("Curatenie", 0, cleanups.get (1).getId ()),
      new CleaningProcedure ("Introducere bauturi in frigider", 1, cleanups.get (0).getId ())
    );

    cleaningProcedureRepository.saveAll (cleaningProcedures);

    final var reviews = List.of (
      new Review ("Good", 5, "Andrei", rooms.get (0).getId ()),
      new Review ("Not Good", 2, "Corina", rooms.get (2).getId ()),
      new Review ("Medium", 4, "Cristian", rooms.get (1).getId ())
    );
    reviewRepository.saveAll (reviews);

    roomRepository.findAll ().forEach (System.out::println);
  }
}
