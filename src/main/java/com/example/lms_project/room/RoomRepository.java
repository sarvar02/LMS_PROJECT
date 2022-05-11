package com.example.lms_project.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    Optional<Room> findByIdAndDeletedAtIsNull(Integer id);

    List<Room> findAllByDeletedAtIsNull();

    boolean existsById(Integer id);

}
