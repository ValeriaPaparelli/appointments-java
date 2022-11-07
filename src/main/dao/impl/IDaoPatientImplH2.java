package main.dao.impl;

import main.dao.IDao;
import main.entidades.Patient;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IDaoPatientImplH2 implements IDao<Patient> {
    private static final Logger LOGGER = Logger.getLogger(IDaoPatientImplH2.class);
    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:/~/appointments-database;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String SQL_GET_PATIENT = "SELECT * FROM PATIENT WHERE id=?";
    private static final String SQL_INSERT_PATIENT = "INSERT INTO PATIENT (NAME, LASTNAME, ADDRESS, DNI, REGISTRATION_DATE) VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_PATIENT = "DELETE FROM PATIENT WHERE id=?";

    @Override
    public List<Patient> toList() throws SQLException {
        Connection connection = null;
        DriverManager driverManager = null;
        List<Patient> patients = new ArrayList<>();

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            String sql = "SELECT * FROM PATIENT";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);


            while (rs.next()){
                LOGGER.info("id: " + rs.getInt(1) + " Apellido: " + rs.getString(2) + " Nombre: " + rs.getString(3));
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String lastName = rs.getString(3);
                String address = rs.getString(4);
                int dni = rs.getInt(5);
                String rDate = rs.getString(6);
                Patient patient = new Patient();
                patient.setId(id);
                patient.setName(name);
                patient.setLastname(lastName);
                patient.setAddress(address);
                patient.setDni(dni);
                patient.setRegistration_date(rDate);

                patients.add(patient);
            }
        } catch(SQLException | ClassNotFoundException exception){
            LOGGER.error("ERROR" + exception);
            connection.close();
        } finally {
            connection.close();
        }

        return patients;
    }

    @Override
    public Patient getById(int id) throws SQLException {
        Connection connection = null;
        DriverManager driverManager = null;
        Patient patient = new Patient();

        try{
            Class.forName(DB_JDBC_DRIVER);

            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement psGetPatient = connection.prepareStatement(SQL_GET_PATIENT);
            psGetPatient.setInt(1, id);
            ResultSet rs = psGetPatient.executeQuery();

            while (rs.next()){
                int idPatient = rs.getInt(1);
                String name = rs.getString(2);
                String lastName = rs.getString(3);
                String address = rs.getString(4);
                int dni = rs.getInt(5);
                String rDate = rs.getString(6);

                patient.setId(idPatient);
                patient.setName(name);
                patient.setLastname(lastName);
                patient.setAddress(address);
                patient.setDni(dni);
                patient.setRegistration_date(rDate);
            }

        } catch(SQLException | ClassNotFoundException exception){
            LOGGER.error("ERROR" + exception);
            connection.close();
        } finally {
            connection.close();
        }

        return patient;
    }

    @Override
    public void add(Patient patient) throws SQLException {
        Connection connection = null;
        DriverManager driverManager = null;

        try{
            Class.forName(DB_JDBC_DRIVER);

            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement psInsertPatient = connection.prepareStatement(SQL_INSERT_PATIENT);
            psInsertPatient.setString(1, patient.getName());
            psInsertPatient.setString(2, patient.getLastname());
            psInsertPatient.setString(3, patient.getAddress());
            psInsertPatient.setInt(4, patient.getDni());
            psInsertPatient.setString(5, patient.getRegistration_date());

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
    public void delete(int id) throws SQLException {
        Connection connection = null;
        DriverManager driverManager = null;
        Patient patient = new Patient();

        try{
            Class.forName(DB_JDBC_DRIVER);

            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement psDeletePatient = connection.prepareStatement(SQL_DELETE_PATIENT);
            psDeletePatient.setInt(1, id);
            ResultSet rs = psDeletePatient.executeQuery();

        } catch(SQLException | ClassNotFoundException exception){
            LOGGER.error("ERROR" + exception);
            connection.close();
        } finally {
            LOGGER.info("El paciente fue eliminado");
            connection.close();
        }
    }
}
