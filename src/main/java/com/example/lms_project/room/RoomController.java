package com.example.lms_project.room;

import com.example.lms_project.room.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Integer id){
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createRoom(@RequestBody RoomDto roomDto){
        roomService.createRoom(roomDto);
        return new ResponseEntity("New room created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRoom(@PathVariable Integer id,
                                           @RequestBody RoomDto roomDto){
        roomService.updateRoom(id, roomDto);
        return new ResponseEntity("New room updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Integer id){
        roomService.deleteRoom(id);
        return new ResponseEntity("New room deleted", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRooms(){
        return ResponseEntity.ok(roomService.getAllRooms());
    }

}
