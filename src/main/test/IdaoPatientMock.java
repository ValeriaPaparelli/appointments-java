package main.test;

import main.dao.IDao;
import main.entidades.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IdaoPatientMock implements IDao<Patient> {

    List<Patient> patients = new ArrayList<>();
    @Override
    public List<Patient> toList() throws SQLException {
        return patients;
    }

    @Override
    public Patient getById(int id) throws SQLException {
        return patients.get(id - 1);
    }

    @Override
    public void add(Patient patient) throws SQLException {
        patient.setId(patients.size() + 1);
        patients.add(patient);
    }

    @Override
    public void update(Patient patient) {

    }

    @Override
    public void delete(int t) {

    }
}
