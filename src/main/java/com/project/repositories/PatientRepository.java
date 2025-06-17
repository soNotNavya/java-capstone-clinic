package com.project.repositories;

import com.project.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // 1. REQUIRED: Find patient by email (exact match)
    Optional<Patient> findByEmail(String email);

    // 2. REQUIRED: Find patients by name (case-insensitive partial match)
    List<Patient> findByNameContainingIgnoreCase(String name);

    // 3. Custom query: Patients with active appointments
    @Query("SELECT DISTINCT p FROM Patient p JOIN p.appointments a WHERE a.status = 'ACTIVE'")
    List<Patient> findPatientsWithActiveAppointments();

    // 4. Custom query: Patients registered in date range
    @Query("SELECT p FROM Patient p WHERE p.registrationDate BETWEEN :start AND :end")
    List<Patient> findPatientsRegisteredBetween(
        @Param("start") LocalDate startDate,
        @Param("end") LocalDate endDate
    );
}
