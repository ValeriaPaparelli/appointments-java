package main;

import main.dao.impl.IDaoPatientImplH2;
import main.entidades.Patient;
import main.services.PatientService;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) throws SQLException {
        Patient patient = new Patient("Miguel", "Hernandez", "San Martin 1230", 30932045, "2022-01-12");
        PatientService patientService = new PatientService(new IDaoPatientImplH2());
            patientService.addPatient(patient);
    }
}
