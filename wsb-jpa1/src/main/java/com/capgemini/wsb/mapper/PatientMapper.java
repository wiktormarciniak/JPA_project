package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class PatientMapper {

    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setRegisteredDate(patientEntity.getRegisteredDate());
        if (patientEntity.getVisits() != null) {
            List<VisitTO> visits = patientEntity.getVisits().stream()
                    .map(VisitMapper::mapToTO)
                    .collect(Collectors.toList());
            patientTO.setVisits(visits);
        }
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setRegisteredDate(patientTO.getRegisteredDate());
        return patientEntity;
    }
}
