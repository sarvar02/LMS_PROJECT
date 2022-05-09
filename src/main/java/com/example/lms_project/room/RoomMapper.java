package com.example.lms_project.room;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room dtoToModel(RoomDto roomDto);

    RoomDto modelToDto(Room room);
}
