package com.example.lms_project.room.service;

import com.example.lms_project.room.Room;
import com.example.lms_project.room.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto getRoomById(Integer id);
    void createRoom(RoomDto roomDto);
    void updateRoom(Integer id, RoomDto roomDto);
    void deleteRoom(Integer id);
    List<RoomDto> getAllRooms();
}
