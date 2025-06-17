package com.project.services;

import com.project.models.Appointment;
import com.project.repositories.AppointmentRepository;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for managing appointment operations in the clinic system.
 * Uses manual dependency injection instead of Spring.
 */
public class AppointmentService {
    
    private final AppointmentRepository appointmentRepository;
    
    // Manual dependency injection via constructor
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    
    /**
     * Books a new appointment
     * @param appointment The appointment to book
     * @return The saved appointment
     * @throws IllegalArgumentException if appointment data is invalid
     */
    public Appointment bookAppointment(Appointment appointment) {
        if (appointment == null || appointment.getDoctor() == null 
            || appointment.getPatient() == null || appointment.getDateTime() == null) {
            throw new IllegalArgumentException("Invalid appointment data");
        }
        
        // Check for availability
        if (!isTimeSlotAvailable(appointment)) {
            throw new IllegalStateException("Doctor is already booked at this time");
        }
        
        return appointmentRepository.save(appointment);
    }
    
    private boolean isTimeSlotAvailable(Appointment appointment) {
        List<Appointment> existing = appointmentRepository
            .findByDoctorAndDate(
                appointment.getDoctor().getId(),
                appointment.getDateTime().toLocalDate()
            );
        
        return existing.stream()
            .noneMatch(a -> a.getDateTime().equals(appointment.getDateTime()));
    }
    
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }
    
    public List<Appointment> getAppointmentsByPatient(String patientName) {
        return appointmentRepository.findAll().stream()
            .filter(a -> a.getPatient().getName().equalsIgnoreCase(patientName))
            .collect(Collectors.toList());
    }
    
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointmentRepository.findByDate(date);
    }
}
