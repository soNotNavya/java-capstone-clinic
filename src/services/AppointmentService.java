package com.project.services;

import com.project.models.Appointment;
import com.project.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Book a new appointment (this was missing)
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment); // Save to DB
    }

    // Get appointments by doctor ID
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findAll()
            .stream()
            .filter(app -> app.getDoctor().getId().equals(doctorId))
            .collect(Collectors.toList());
    }

    // Get appointments by patient name
    public List<Appointment> getAppointmentsByPatient(String patientName) {
        return appointmentRepository.findAll()
            .stream()
            .filter(app -> app.getPatient().getName().equalsIgnoreCase(patientName))
            .collect(Collectors.toList());
    }

    // Get appointments by date
    public List<Appointment> getAppointmentsByDate(String date) {
        return appointmentRepository.findAll()
            .stream()
            .filter(app -> app.getDate().equals(date))
            .collect(Collectors.toList());
    }
}
