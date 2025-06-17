package com.project.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id @GeneratedValue
    private Long id;
    
    private String status; // e.g., "ACTIVE", "CANCELLED"
    
    @ManyToOne
    private Patient patient;
    
    private LocalDateTime dateTime;
    
    // Getters and setters
    public Long getId() { return id; }
    public String getStatus() { return status; }
    public Patient getPatient() { return patient; }
    public LocalDateTime getDateTime() { return dateTime; }
    
    public void setStatus(String status) { this.status = status; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
