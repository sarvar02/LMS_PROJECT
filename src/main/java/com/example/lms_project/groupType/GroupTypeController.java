package com.example.lms_project.groupType;

import com.example.lms_project.groupType.service.GroupTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/group-type")
public class GroupTypeController {

    private final GroupTypeService groupTypeService;

    public GroupTypeController(GroupTypeService groupTypeService) {
        this.groupTypeService = groupTypeService;
    }

    @GetMapping
    public ResponseEntity<List<GroupTypeDto>> getAllGroupTypes(){
        return ResponseEntity.ok(groupTypeService.getAllGroupTypes());
    }

    @PostMapping
    public ResponseEntity<Void> createGroupType(@RequestBody GroupTypeDto groupTypeDto){
        groupTypeService.createGroupType(groupTypeDto);
        return new ResponseEntity("New group type created !", CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGroupType(@PathVariable Integer id,
                                                @RequestBody GroupTypeDto groupTypeDto){
        groupTypeService.updateGroupType(id, groupTypeDto);
        return new ResponseEntity("Group type updated !", OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupType(@PathVariable Integer id){
        groupTypeService.deleteGroupType(id);
        return new ResponseEntity("Group type deleted !", OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupTypeDto> getGroupTypeById(@PathVariable Integer id){
        return ResponseEntity.ok(groupTypeService.getGroupTypeById(id));
    }

}
