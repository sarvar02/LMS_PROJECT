package com.example.lms_project.group;

import com.example.lms_project.group.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable Integer id){
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createGroup(@RequestBody GroupDto groupDto){
        groupService.createGroup(groupDto);
        return new ResponseEntity("New Group Created !", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGroup(@PathVariable Integer id,
                                            @RequestBody GroupDto groupDto){
        groupService.updateGroup(id, groupDto);
        return new ResponseEntity("Group Updated !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id){
        groupService.deleteGroup(id);
        return new ResponseEntity("Group Deleted !", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GroupDto>> getAllGroups(){
        return ResponseEntity.ok(groupService.getAllGroups());
    }
}
