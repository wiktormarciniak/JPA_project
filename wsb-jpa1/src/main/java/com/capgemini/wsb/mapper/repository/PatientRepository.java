package com.capgemini.wsb.mapper.repository;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query("SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visitCount")
    List<PatientEntity> findByVisitsCountGreaterThan(int visitCount);

    List<PatientEntity> findByLastName(String lastName);

    List<PatientEntity> findByRegisteredDateBefore(LocalDate date);
}
