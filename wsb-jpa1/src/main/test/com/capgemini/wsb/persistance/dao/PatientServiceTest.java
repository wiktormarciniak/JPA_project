import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.repository.DoctorRepository;
import com.capgemini.wsb.mapper.repository.PatientRepository;
import com.capgemini.wsb.mapper.repository.VisitRepository;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    @Test
    public void testDeletePatient() {
        // given
        Long patientId = 1L; // assuming this patient has visits and is linked to doctors
        int totalDoctorsBeforeDeletion = doctorRepository.findAll().size();

        // when
        patientService.deletePatient(patientId);

        // then
        assertThat(patientRepository.findById(patientId)).isEmpty();
        assertThat(visitRepository.findAllByPatientId(patientId)).isEmpty();
        assertThat(doctorRepository.findAll().size()).isEqualTo(totalDoctorsBeforeDeletion);

    }

    @Test
    public void testGetPatientById() {
        // given
        Long patientId = 1L;

        // when
        PatientTO patient = patientService.findById(patientId);

        // then
        assertThat(patient).isNotNull();
        assertThat(patient.getId()).isEqualTo(patientId);
        assertThat(patient.getVisits()).isNotEmpty();
        assertThat(patient.getRegisteredDate()).isBefore(LocalDate.now());
    }

    @Test
    public void testGetAllVisitsForPatient() {
        // given
        Long patientId = 1L;

        // when
        List<VisitTO> visits = patientService.getAllVisitsForPatient(patientId);

        // then
        assertThat(visits).isNotNull();
        assertThat(visits.size()).isGreaterThan(0);
    }
}