package com.fairrepair.fairrepair.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fairrepair.fairrepair.model.Appointments;
import com.fairrepair.fairrepair.repository.AppointmentsRepo;

@Service
public class AppointmentService {

    @Autowired
    AppointmentsRepo appointmentsRepo;

    public List<Appointments> findAll() {
        return (List<Appointments>) appointmentsRepo.findAll();
    }

    public Appointments save(Appointments appt) {
        return appointmentsRepo.save(appt);
    }

    public Appointments findById(Long id) {
        return appointmentsRepo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        appointmentsRepo.deleteById(id);
    }
}
