package controllers;

import models.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    // Dummy method to simulate token validation
    private boolean isValidToken(String token) {
        return token != null && token.equals("12345"); // Replace with real validation later
    }

    @GetMapping("/availability")
    public Map<String, Object> getDoctorAvailability(
            @RequestParam String role,
            @RequestParam Long doctorId,
            @RequestParam String date,
            @RequestParam String token) {

        Map<String, Object> response = new HashMap<>();

        // Token validation
        if (!isValidToken(token)) {
            response.put("status", "error");
            response.put("message", "Invalid token");
            return response;
        }

        // Role-based access check (can expand later)
        if (!role.equalsIgnoreCase("user") && !role.equalsIgnoreCase("admin")) {
            response.put("status", "error");
            response.put("message", "Access denied for role: " + role);
            return response;
        }

        // Dummy availability (replace with DB/service logic)
        Map<String, String> availability = new HashMap<>();
        availability.put("09:00 AM", "available");
        availability.put("10:00 AM", "booked");
        availability.put("11:00 AM", "available");

        response.put("status", "success");
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("availability", availability);

        return response;
    }
}
