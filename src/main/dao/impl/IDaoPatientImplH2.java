package main.dao.impl;

import main.dao.IDao;
import main.entidades.Patient;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class IDaoPatientImplH2 implements IDao<Patient> {

    private static final Logger LOGGER = Logger.getLogger(IDaoPatientImplH2.class);

    private static final String DB_JDBC_DRIVER = "org.h2.Driver";

    private static final String DB_URL = "jdbc:h2:/~/appointments-database;INIT=RUNSCRIPT FROM 'create.sql'";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "";

    private static final String SQL_INSERT_PATIENT = "INSERT INTO PATIENT (NAME, LASTNAME, ADDRESS, DNI, REGISTRATION_DATE) VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Patient> toList() {
        return null;
    }

    @Override
    public void add(Patient patient) throws SQLException {
        Connection connection = null;
        DriverManager driverManager = null;

        try{
            Class.forName(DB_JDBC_DRIVER);

            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Crear sentencia
            PreparedStatement psInsertPatient = connection.prepareStatement(SQL_INSERT_PATIENT);
            psInsertPatient.setString(1, patient.getName());
            psInsertPatient.setString(2, patient.getLastname());
            psInsertPatient.setString(3, patient.getAddress());
            psInsertPatient.setInt(4, patient.getDni());
            psInsertPatient.setString(5, patient.getRegistration_date());
            //Ejecutar Sentencia
            psInsertPatient.execute();
            LOGGER.info("Paciente creado correctamente.");
            psInsertPatient.close();

        } catch(SQLException | ClassNotFoundException exception){
            LOGGER.error("ERROR" + exception);
        } finally {
            connection.close();
        }
    }

    @Override
    public void update(Patient t) {

    }

    @Override
    public void delete(int t) {

    }
}
