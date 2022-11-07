package main;

import main.dao.IDao;
import main.dao.impl.IDaoPatientImplH2;
import main.entidades.Patient;
import main.services.PatientService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) throws SQLException {
        IDao<Patient> idao = new IDaoPatientImplH2();
        PatientService patientService = new PatientService(idao);

        Patient patient1 = new Patient("Valeria", "Martinez", "Ameghino 3627", 22658309, "2022-04-08");
        patientService.addPatient(patient1);

        Patient patient2 = new Patient("Leandro", "Perez", "San Martin 3627", 20654309, "2022-10-08");
        patientService.addPatient(patient2);

        Patient patient3 = new Patient("Romina", "Vallejos", "Diaz Velez 327", 22658309, "2022-11-08");
        patientService.addPatient(patient3);

        Patient patientSaved = patientService.getById(3);

        LOGGER.info(patientSaved.getName());

        List<Patient> patients = patientService.toList();

        LOGGER.info(patients.get(2).getName());

    }
}
