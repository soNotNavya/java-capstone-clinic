package services;

import models.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private List<Appointment> appointmentList = new ArrayList<>();

    // Dummy data for testing
    public AppointmentService() {
        appointmentList.add(new Appointment(1L, "2025-06-20", "10:00", 100L, "John"));
        appointmentList.add(new Appointment(2L, "2025-06-20", "11:00", 101L, "Jane"));
        appointmentList.add(new Appointment(3L, "2025-06-21", "12:00", 100L, "Alice"));
    }

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentList.stream()
                .filter(app -> app.getDoctorId().equals(doctorId))
                .collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsByDate(String date) {
        return appointmentList.stream()
                .filter(app -> app.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsByPatient(String patientName) {
        return appointmentList.stream()
                .filter(app -> app.getPatientName().equalsIgnoreCase(patientName))
                .collect(Collectors.toList());
    }

    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);

     

    }
}
