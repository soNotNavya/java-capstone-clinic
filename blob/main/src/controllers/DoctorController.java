package com.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class DoctorController {

    // Dummy secret token for validation
    private static final String SECRET_TOKEN = "valid-token";

    /**
     * Retrieves availability for a doctor on a given date, validating user and token.
     *
     * @param user      The role of the user (e.g., patient, admin)
     * @param doctorId  The ID of the doctor
     * @param date      The date for which availability is requested
     * @param token     The authentication token
     * @return          Availability data in a structured JSON response
     */
    @GetMapping("/availability/{user}/{doctorId}/{date}/{token}")
    public ResponseEntity<Map<String, Object>> getAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        // Simulate token validation
        if (!SECRET_TOKEN.equals(token)) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Invalid token.");
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        }

        // Optional: Check user role
        if (!user.equalsIgnoreCase("patient") && !user.equalsIgnoreCase("admin")) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Access denied. Invalid user role.");
            return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
        }

        // Simulate doctor availability
        Map<String, Object> response = new HashMap<>();
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("available", true);
        response.put("timeSlots", new String[]{"10:00 AM", "11:30 AM", "02:00 PM"});
        response.put("requestedBy", user);

        return ResponseEntity.ok(response);
    }
}


