package com.project.services;

import com.project.models.Doctor;
import com.project.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // 1. Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // 2. Get doctor by ID
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // 3. Add new doctor (with validation)
    public Doctor addDoctor(Doctor doctor) {
        if (doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return doctorRepository.save(doctor);
    }

    // 4. Update doctor details
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setName(updatedDoctor.getName());
                    doctor.setSpecialization(updatedDoctor.getSpecialization());
                    doctor.setEmail(updatedDoctor.getEmail());
                    return doctorRepository.save(doctor);
                })
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
    }

    // 5. Delete doctor
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
