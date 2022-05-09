package com.example.lms_project.room.service;

import com.example.lms_project.exception.ServerBadRequestException;
import com.example.lms_project.room.Room;
import com.example.lms_project.room.RoomDto;
import com.example.lms_project.room.RoomMapper;
import com.example.lms_project.room.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public RoomDto getRoomById(Integer id) {
        Room room = getEntity(id);
        return roomMapper.modelToDto(room);
    }

    @Override
    public void createRoom(RoomDto roomDto) {
        Room room = roomMapper.dtoToModel(roomDto);
        room.setCreatedAt(LocalDateTime.now());
        room.setStatus(true);

        saveToDatabase(room);
    }

    @Override
    public void updateRoom(Integer id, RoomDto roomDto) {
        Room room = getEntity(id);
        Room newRoom = roomMapper.dtoToModel(roomDto);

        newRoom.setId(id);
        newRoom.setCreatedAt(room.getCreatedAt());
        newRoom.setStatus(room.getStatus());
        newRoom.setUpdatedAt(LocalDateTime.now());

        saveToDatabase(newRoom);
    }

    @Override
    public void deleteRoom(Integer id) {
        Room room = getEntity(id);
        room.setDeletedAt(LocalDateTime.now());
        saveToDatabase(room);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        List<Room> rooms = roomRepository.findAllByDeletedAtIsNull();
        if(rooms.isEmpty())
            throw new ServerBadRequestException("Room not found !");

        return rooms.stream()
                .map(roomMapper::modelToDto)
                .collect(Collectors.toList());
    }

//       | <- Secondary function -> |
    public Room getEntity(Integer id){
        return roomRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("Room not found !"));
    }

    @Transactional
    public void saveToDatabase(Room room){
        roomRepository.save(room);
    }

}
