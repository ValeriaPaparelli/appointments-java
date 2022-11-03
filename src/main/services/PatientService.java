package main.services;

import main.dao.IDao;
import main.dao.impl.IDaoPatientImplH2;
import main.entidades.Patient;

import java.sql.SQLException;
import java.util.List;


public class PatientService {
    private IDao patientDao;

    public PatientService(IDao<Patient> patientIDao) {
        this.patientDao = patientIDao;
    }

    public IDao<Patient> getPatientIDao() {
        return patientDao;
    }

    public void setPatientIDao(IDao<Patient> patientIDao) {
        this.patientDao = patientIDao;
    }

    public List<Patient> toList(){
        return patientDao.toList();
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
