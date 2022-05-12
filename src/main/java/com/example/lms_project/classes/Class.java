package com.example.lms_project.classes;

import com.example.lms_project.room.Room;
import com.example.lms_project.userGroup.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ("classes"))
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("name"))
    private String name;

    @ManyToOne
    @JoinColumn(name = ("room_id"), insertable = false, updatable = false)
    private Room room;

    @Column(name = ("room_id"))
    private Integer roomId;

//     Todo Attandence type

    @ManyToOne
    @JoinColumn(name = ("user_group_id"), insertable = false, updatable = false)
    private UserGroup userGroup;

    @Column(name = ("user_group_id"))
    private Integer userGroupId;

    @Column(name = ("status"))
    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
