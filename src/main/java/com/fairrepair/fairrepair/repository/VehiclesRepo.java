package com.fairrepair.fairrepair.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fairrepair.fairrepair.model.Vehicle;

@Repository
public interface VehiclesRepo extends CrudRepository<Vehicle, Long> {

}
