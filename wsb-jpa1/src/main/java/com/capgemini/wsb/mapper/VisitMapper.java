package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public class VisitMapper {

    public static VisitTO mapToTO(VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());

        if (visitEntity.getDoctor() != null) {
            visitTO.setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor()));
        }

        if (visitEntity.getPatient() != null) {
            PatientTO patientTO = new PatientTO();
            patientTO.setId(visitEntity.getPatient().getId());
            patientTO.setFirstName(visitEntity.getPatient().getFirstName());
            patientTO.setLastName(visitEntity.getPatient().getLastName());
            visitTO.setPatient(patientTO);
        }

        return visitTO;
    }

    public static VisitEntity mapToEntity(VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());

        return visitEntity;
    }
}

