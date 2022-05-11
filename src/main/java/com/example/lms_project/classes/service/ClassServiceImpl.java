package com.example.lms_project.classes.service;

import com.example.lms_project.classes.Class;
import com.example.lms_project.classes.ClassDto;
import com.example.lms_project.classes.ClassMapper;
import com.example.lms_project.classes.ClassRepository;
import com.example.lms_project.exception.ServerBadRequestException;
import com.example.lms_project.room.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService{

    private final ClassRepository classRepository;
    private final ClassMapper classMapper;
    private final RoomRepository roomRepository;

    public ClassServiceImpl(ClassRepository classRepository, ClassMapper classMapper, RoomRepository roomRepository) {
        this.classRepository = classRepository;
        this.classMapper = classMapper;
        this.roomRepository = roomRepository;
    }


    @Override
    public ClassDto getClassById(Integer id) {
        Class clas = getEntity(id);
        return classMapper.modelToDto(clas);
    }

    @Override
    public void createClass(ClassDto classDto) {

//      Checking...
        checkForExist(classDto.getRoomId());

        Class clas = classMapper.dtoToModel(classDto);
        clas.setCreatedAt(LocalDateTime.now());
        clas.setStatus(true);

        saveToDatabase(clas);
    }

    @Override
    public void updateCLass(Integer id, ClassDto classDto) {
//        Checking...
        checkForExist(classDto.getRoomId());

        Class clas = getEntity(id);
        Class newClass = classMapper.dtoToModel(classDto);

        newClass.setId(id);
        newClass.setCreatedAt(clas.getCreatedAt());
        newClass.setStatus(clas.getStatus());
        newClass.setUpdatedAt(clas.getUpdatedAt());

        saveToDatabase(newClass);
    }

    @Override
    public void deleteClass(Integer id) {
        Class clas = getEntity(id);
        clas.setDeletedAt(LocalDateTime.now());
        saveToDatabase(clas);
    }

    @Override
    public List<ClassDto> getAllClasses() {
        List<Class> classList = classRepository.findAllByDeletedAtIsNull();
        if(classList.isEmpty())
            throw new ServerBadRequestException("Class not found !");

        return classList.stream()
                .map(classMapper::modelToDto)
                .collect(Collectors.toList());
    }

//    | <- Secondary function -> |

    public Class getEntity(Integer id){
        return classRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("CLass not found !"));
    }

    public void checkForExist(Integer roomId){
        if(!roomRepository.existsById(roomId)){
            throw new ServerBadRequestException("Room not found !");
        }
    }

    @Transactional
    public void saveToDatabase(Class clas){
        classRepository.save(clas);
    }
}
