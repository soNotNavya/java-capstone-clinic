package com.project.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private LocalDate registrationDate;
    
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
    
    // Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public List<Appointment> getAppointments() { return appointments; }
    
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setRegistrationDate(LocalDate date) { this.registrationDate = date; }
}
