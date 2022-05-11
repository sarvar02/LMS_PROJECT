package com.example.lms_project.sertificate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filter {
    private Integer page;
    private Integer size;
    private String sortBy;
    private Sort.Direction directionF;
}
