package com.example.lms_project.classes;

import com.example.lms_project.classes.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(classService.getClassById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createClass(@RequestBody ClassDto classDto){
        classService.createClass(classDto);
        return new ResponseEntity("New class created !", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClass(@PathVariable Integer id,
                                            @RequestBody ClassDto classDto){
        classService.updateCLass(id, classDto);
        return new ResponseEntity("Class updated!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Integer id){
        classService.deleteClass(id);
        return new ResponseEntity("Class deleted !", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClassDto>> getAllCourses(){
        return ResponseEntity.ok(classService.getAllClasses());
    }
}
