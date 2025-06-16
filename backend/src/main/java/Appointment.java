package com.clinic.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import jakarta.persistence.*;


@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne
@JoinColumn(name = "doctor_id")
private Doctor doctor;

@ManyToOne
@JoinColumn(name = "patient_id")
private Patient patient;

    private LocalDateTime appointmentTime;

    public Appointment() {}

    public Appointment(Long doctorId, String patientName, LocalDateTime appointmentTime) {
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.appointmentTime = appointmentTime;
    }

    // Getters and Setters
    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointment

    package models;

import javax.persistence.*;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String date;
    private String time;

    // Constructors, getters, setters
}


