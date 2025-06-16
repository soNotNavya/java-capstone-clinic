import com.clinic.models.Doctor;
package com.clinic.controllers;

import com.clinic.models.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private List<Doctor> doctors = new ArrayList<>();

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        for (Doctor doc : doctors) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }
}
