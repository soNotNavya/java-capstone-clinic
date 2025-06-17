package com.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DoctorController {

    // Dummy method to simulate doctor availability check
    @GetMapping("/doctors/{doctorId}/availability")
    public ResponseEntity<Map<String, Object>> getDoctorAvailability(@PathVariable Long doctorId) {
        // In real app, validate token and fetch doctor availability from DB

        // Dummy availability response
        Map<String, Object> response = new HashMap<>();
        response.put("doctorId", doctorId);
        response.put("available", true);
        response.put("timeSlots", new String[]{"10:00 AM", "11:30 AM", "02:00 PM"});

        return ResponseEntity.ok(response);
    }
}

