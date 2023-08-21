package com.fairrepair.fairrepair.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fairrepair.fairrepair.Model.Appointments;

@Repository
public interface AppointmentsRepo extends CrudRepository <Appointments, Long> {

}
