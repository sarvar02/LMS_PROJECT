package com.example.lms_project.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from users u where u.id = ?1 and u.deletedAt is null")
    Optional<User> findByIdAndDeletedAtIsNull(Integer id);

    @Query("select u from users u where u.deletedAt is null")
    List<User> findAllByDeletedAtIsNull();

    @Query("select u from users u where u.phone = ?1 and u.deletedAt is null")
    Optional<User> findByPhoneAndDeletedAtIsNull(String phone);
}
