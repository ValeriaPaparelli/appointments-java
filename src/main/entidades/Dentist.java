package main.entidades;

public class Dentist {

    private int id;
    private String lastname;
    private String name;
    private String medical_license;

    public Dentist(int id, String lastname, String name, String medicalLicense) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.medical_license = medicalLicense;
    }

    //validate fullname

    //validate medicalLicense

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

    public String getMedical_license() {
        return medical_license;
    }

    public void setMedical_license(String medical_license) {
        this.medical_license = medical_license;
    }
}
