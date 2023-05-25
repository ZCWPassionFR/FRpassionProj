package com.fairrepair.fairrepair.repository;

import org.springframework.data.repository.CrudRepository;
import com.fairrepair.fairrepair.model.VehicleService;

public interface ServiceRepo extends CrudRepository<VehicleService, Long> {

}
