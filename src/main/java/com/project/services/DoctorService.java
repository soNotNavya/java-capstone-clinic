package com.project.services;

import com.project.models.Doctor;
import com.project.models.DoctorAvailability;
import com.project.repositories.DoctorRepository;
import com.project.repositories.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 1. CRUD METHODS (EXISTING)
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // 2. NEW: VALIDATE DOCTOR LOGIN
    public boolean validateDoctorCredentials(String email, String rawPassword) {
        Optional<Doctor> doctor = doctorRepository.findByEmail(email);
        return doctor.isPresent() && 
               passwordEncoder.matches(rawPassword, doctor.get().getPassword());
    }

    // 3. NEW: GET AVAILABLE TIME SLOTS FOR A DATE
    public List<DoctorAvailability> getAvailableSlots(Long doctorId, LocalDate date) {
        return availabilityRepository.findByDoctorIdAndDateAndIsAvailable(
            doctorId, 
            date, 
            true
        );
    }

    // 4. NEW: ADD/UPDATE AVAILABILITY
    public DoctorAvailability setAvailability(
        Long doctorId, 
        LocalDate date, 
        String timeSlot, 
        boolean isAvailable
    ) {
        DoctorAvailability availability = new DoctorAvailability();
        availability.setDoctorId(doctorId);
        availability.setDate(date);
        availability.setTimeSlot(timeSlot);
        availability.setIsAvailable(isAvailable);
        return availabilityRepository.save(availability);
    }
}
