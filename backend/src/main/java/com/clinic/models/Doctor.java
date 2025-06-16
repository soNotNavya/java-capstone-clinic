package com.clinic.models;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private boolean availabilityStatus;

    public Doctor() {
    }

    public Doctor(int doctorId, String name, String specialization, boolean availabilityStatus) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.availabilityStatus = availabilityStatus;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", availabilityStatus=" + availabilityStatus +
                '}';
    }
}

