package com.fairrepair.fairrepair.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fairrepair.fairrepair.model.Appointments;

@Repository
public interface AppointmentsRepo extends CrudRepository <Appointments, Long> {

}
