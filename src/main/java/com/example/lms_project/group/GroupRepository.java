package com.example.lms_project.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    Optional<Group> findByIdAndDeletedAtIsNull(Integer id);

    List<Group> findAllByDeletedAtIsNull();
}
