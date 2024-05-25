import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.repository.PatientRepository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testFindByLastName() {
        // when
        List<PatientEntity> patients = patientRepository.findByLastName("Lewandowski");

        // then
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isEqualTo(1);
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

    @Test
    public void testFindByVisitsCountGreaterThan() {
        // when
        int minVisits = 1;
        List<PatientEntity> patients = patientRepository.findByVisitsCountGreaterThan(minVisits);

        // then
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isEqualTo(2);
    }

    @Test
    public void testFindByRegisteredDateBefore() {
        // when
        LocalDate date = LocalDate.of(2023, 1, 1);
        List<PatientEntity> patients = patientRepository.findByRegisteredDateBefore(date);

        // then
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isEqualTo(2);
    }
}