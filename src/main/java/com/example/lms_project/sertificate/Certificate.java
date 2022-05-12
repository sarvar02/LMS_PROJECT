package com.example.lms_project.sertificate;
import com.example.lms_project.course.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = ("certificates"))
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = ("course_id"), insertable = false, updatable = false)
    private Course course;

    @Column(name = ("subject_id"))
    private Integer courseId;

    @Column(name = ("token"))
    private String token;

    @Column(name = ("name"))
    private String name;

    @Column(name = ("surname"))
    private String surname;

    @Column(name = ("url"))
    private String url;

    @Column(name = ("path"))
    private String path;

    @Column(name = ("finished_date"))
    private LocalDate finishedDate;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
