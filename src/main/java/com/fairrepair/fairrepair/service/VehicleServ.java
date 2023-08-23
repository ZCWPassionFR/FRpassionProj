package com.fairrepair.fairrepair.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fairrepair.fairrepair.Model.Vehicle;
import com.fairrepair.fairrepair.repository.ServiceRepo;

@Service
public class VehicleServ {
    
    @Autowired
    ServiceRepo serviceRepo;

    public Vehicle save(Vehicle vehicle) {
        return null;
    }

    public List<Vehicle> findAll() {
        return null;
    }

    public Optional<Vehicle> findById(Long id) {
        return null;
    }

    public void deleteById(Long id) {
    }


    
}
