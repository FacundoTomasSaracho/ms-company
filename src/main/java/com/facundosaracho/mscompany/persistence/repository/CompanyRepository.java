package com.facundosaracho.mscompany.persistence.repository;

import com.facundosaracho.mscompany.persistence.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    List<CompanyEntity> findByRegisteredAtGreaterThanEqual(LocalDateTime registeredAt);
}
