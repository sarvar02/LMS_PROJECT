package com.example.lms_project.userGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {

    Optional<UserGroup> findByIdAndDeletedAtIsNull(Integer id);

    List<UserGroup> findAllByDeletedAtIsNull();

    List<UserGroup> findAllByUserIdAndDeletedAtIsNull(Integer userId);
}
