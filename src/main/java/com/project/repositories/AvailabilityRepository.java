package com.project.repositories;

import com.project.models.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository 
       extends JpaRepository<DoctorAvailability, Long> {
    
    List<DoctorAvailability> findByDoctorIdAndDateAndIsAvailable(
        Long doctorId, 
        LocalDate date, 
        boolean isAvailable
    );
}
