package com.project.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DoctorAvailability {
    @Id @GeneratedValue
    private Long id;
    private Long doctorId;
    private LocalDate date;
    private String timeSlot; // e.g., "09:00-10:00"
    private boolean isAvailable;

    // Getters/setters
}
