package com.example.lms_project.attandenceType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttandenceTypeRepository extends JpaRepository<AttandenceType, Integer> {

    Optional<AttandenceType> findByIdAndDeletedAtIsNull(Integer id);

    List<AttandenceType> findAllByDeletedAtIsNull();
}
