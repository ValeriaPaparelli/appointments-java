package main.services;

import main.dao.IDao;
import main.entidades.Patient;

import java.sql.SQLException;
import java.util.List;

public class PatientService {
    private IDao patientDao;

    public PatientService(IDao<Patient> patientIDao) {
        this.patientDao = patientIDao;
    }

    public List<Patient> toList() throws SQLException {
        return patientDao.toList();
    }

    public Patient getById(int id) throws SQLException {
        return (Patient) patientDao.getById(id);
    }

    public void addPatient(Patient patient) throws SQLException {
        patientDao.add(patient);
    }

    public void updatePatient(Patient patient){
        patientDao.update(patient);
    }

    public void deletePatient(int id){
        patientDao.delete(id);
    }
}
