package com.example.lms_project.userGroup;

import com.example.lms_project.userGroup.service.UserGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-group")
public class UserGroupController {

    private final UserGroupService userGroupService;

    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGroupDto> getUserGroup(@PathVariable Integer id){
        return ResponseEntity.ok(userGroupService.getUserGroupById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createUserGroup(@RequestBody UserGroupDto userGroupDto){
        userGroupService.createUserGroup(userGroupDto);
        return new ResponseEntity("User group created !", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserGroup(@PathVariable Integer id,
                                                @RequestBody UserGroupDto userGroupDto){
        userGroupService.updateUserGroup(id, userGroupDto);
        return new ResponseEntity("User group updated !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserGroup(@PathVariable Integer id){
        userGroupService.deleteUserGroup(id);
        return new ResponseEntity("User group deleted !", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserGroupDto>> getAllUserGroups(){
        return ResponseEntity.ok(userGroupService.getAllUserGroups());
    }

}
