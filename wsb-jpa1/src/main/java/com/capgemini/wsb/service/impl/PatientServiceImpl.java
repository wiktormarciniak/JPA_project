package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.mapper.repository.PatientRepository;
import com.capgemini.wsb.mapper.repository.VisitRepository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final VisitRepository visitRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, VisitRepository visitRepository) {
        this.patientRepository = patientRepository;
        this.visitRepository = visitRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public PatientTO findById(final Long id) {
        Optional<PatientEntity> patient = patientRepository.findById(id);
        return patient.map(PatientMapper::mapToTO).orElse(null);
    }

    @Override
    @Transactional
    public void deletePatient(final Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VisitTO> getAllVisitsForPatient(final Long patientId) {
        return visitRepository.findByPatientId(patientId)
                .stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }
}
