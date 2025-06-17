package com.clinic.models;  // Change the package to match your project structure

import javax.persistence.*;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private boolean availabilityStatus;

    // Constructors
    public Doctor() {
    }

    public Doctor(String name, String specialization, boolean availabilityStatus) {
        this.name = name;
        this.specialization = specialization;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", availabilityStatus=" + availabilityStatus +
                '}';
        
        private String password; // Encrypted

// Add getter/setter
public String getPassword() { return password; }
public void setPassword(String password) {
    this.password = passwordEncoder.encode(password); 
}
    }
}



