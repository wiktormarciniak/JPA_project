package com.capgemini.wsb.mapper.repository;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    DoctorEntity findByDoctorNumber(String doctorNumber);
}
