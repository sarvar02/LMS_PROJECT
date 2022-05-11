package com.example.lms_project.sertificate;
import com.example.lms_project.course.CourseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertificateDto extends Filter{

    private Long id;
    private CourseDto courseDto;
    private Long courseId;
    private String token;
    private String name;
    private String surname;
    private String url;
    private String path;
    private LocalDate finishedDate;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
