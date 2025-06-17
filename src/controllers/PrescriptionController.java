package com.project.controllers;

import com.project.models.Prescription;
import com.project.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@Valid @RequestBody Prescription prescription) {
        Prescription savedPrescription = prescriptionService.createPrescription(prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrescription);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        return ResponseEntity.ok(prescription);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByPatient(@PathVariable Long patientId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPatientId(patientId);
        return ResponseEntity.ok(prescriptions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(
            @PathVariable Long id, 
            @Valid @RequestBody Prescription prescription) {
        Prescription updatedPrescription = prescriptionService.updatePrescription(id, prescription);
        return ResponseEntity.ok(updatedPrescription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }
}
