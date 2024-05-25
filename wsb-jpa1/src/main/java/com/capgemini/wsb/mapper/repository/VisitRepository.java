package com.capgemini.wsb.mapper.repository;

import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
    // Add methods to fetch visits by patient ID if necessary
    List<VisitEntity> findByPatientId(Long patientId);
    List<VisitEntity> findAllByPatientId(Long patientId);
}
