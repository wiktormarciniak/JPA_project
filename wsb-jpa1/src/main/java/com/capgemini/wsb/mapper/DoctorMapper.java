package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;

public class DoctorMapper {

    public static DoctorTO mapToTO(DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setSpecialization(doctorEntity.getSpecialization().toString());

        return doctorTO;
    }

    public static DoctorEntity mapToEntity(DoctorTO doctorTO) {
        if (doctorTO == null) {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        if (doctorTO.getSpecialization() != null) {
            doctorEntity.setSpecialization(Specialization.valueOf(doctorTO.getSpecialization()));
        }

        return doctorEntity;
    }
}

