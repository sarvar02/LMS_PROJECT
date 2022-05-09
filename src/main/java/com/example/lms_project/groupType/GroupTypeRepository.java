package com.example.lms_project.groupType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupTypeRepository extends JpaRepository<GroupType, Integer> {

    Optional<GroupType> findByIdAndDeletedAtIsNull(Integer id);

    List<GroupType> findAllByDeletedAtIsNull();

    boolean existsById(Integer id);
}
