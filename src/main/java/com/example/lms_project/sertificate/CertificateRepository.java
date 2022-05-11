package com.example.lms_project.sertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long>, JpaSpecificationExecutor<Certificate> {
    @Query("select c from certificates c where c.token = ?1 and c.deletedAt is null")
    Optional<Certificate> findByTokenAndDeletedAtIsNull(String token);
}
