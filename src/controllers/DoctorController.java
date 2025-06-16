package controllers;

import models.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorController {
    private List<Doctor> doctors = new ArrayList<>();

    // Dummy constructor with preloaded doctors
    public DoctorController() {
        doctors.add(new Doctor(1L, "Dr. Meena", "Cardiology", "Available"));
        doctors.add(new Doctor(2L, "Dr. Iyer", "Dermatology", "Unavailable"));
    }

    // Method to return availability of a doctor by ID
    public String getDoctorAvailability(Long doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(doctorId)) {
                return doctor.getAvailabilityStatus();
            }
        }
        return "Doctor not found";
    }
}
