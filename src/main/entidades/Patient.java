package main.entidades;

public class Patient {
    private int id;
    private String lastname;
    private String name;
    private String address;
    private int dni;
    private String registration_date;

    public Patient() { }

    public Patient(String name, String lastname, String address, int dni, String registrationDate) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.dni = dni;
        this.registration_date = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}
