package main.test;

import main.entidades.Patient;
import main.services.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class PatientTest {

    @Test
    public void test_all_methods () throws SQLException {

        PatientService patientService = new PatientService(new IdaoPatientMock());

        // Testeo del add y el toList
        Patient patient1 = new Patient("Valeria", "Paparelli", "Senillosa 33", 3234561, "2020-05-02");
        patientService.addPatient(patient1);

        Patient patient2 = new Patient("Pablo", "Lorenzo", "San Martin 33", 30102989, "2020-10-04");
        patientService.addPatient(patient2);

        List<Patient>  patients = patientService.toList();
        Patient testPatient1 = patients.get(0);

        Assertions.assertEquals(patient1.getName(), testPatient1.getName());

        //Testeo del getPatientById
        Patient testPatient2 = patientService.getById(2);

        Assertions.assertEquals(patient2.getName(), testPatient2.getName());
    }

}
