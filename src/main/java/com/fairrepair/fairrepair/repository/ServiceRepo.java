package com.fairrepair.fairrepair.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fairrepair.fairrepair.Model.VehicleService;

@Repository
public interface ServiceRepo extends CrudRepository<VehicleService, Long> {

}
