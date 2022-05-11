package com.example.lms_project.attandenceType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = ("attandence_types"))
public class AttandenceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("name"))
    private String name;

    @Column(name = ("status"))
    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
