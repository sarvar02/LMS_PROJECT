package com.example.lms_project.user.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from roles r where r.id = ?1 and r.deletedAt is null")
    Optional<Role> findByIdAndDeletedAtIsNull(Integer id);

    @Query("select r from roles r where r.deletedAt is null")
    List<Role> findAllByDeletedAtIsNull();
}
