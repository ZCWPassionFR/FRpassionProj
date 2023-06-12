package com.fairrepair.fairrepair.controller;

import com.fairrepair.fairrepair.model.Vehicle;
import com.fairrepair.fairrepair.repository.VehiclesRepo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Transactional
public class VehicleController {

    private final Logger log = LoggerFactory.getLogger(VehicleController.class);

    private static final String ENTITY_NAME = "vehicle";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VehiclesRepo vehiclesRepo;

    public VehicleController(VehiclesRepo vehiclesRepo) {
        this.vehiclesRepo = vehiclesRepo;
    }

    /**
     * {@code POST  /vehicles} : Create a new vehicle.
     */
    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) throws URISyntaxException {
        log.debug("REST request to save Vehicle : {}", vehicle);
        Vehicle result = vehiclesRepo.save(vehicle);
        return ResponseEntity.ok(result);
    }

    /**
     * {@code PUT  /vehicles/:id} : Updates an existing vehicle.
     */
    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id", required = false) final Long id,
            @RequestBody Vehicle vehicle)
            throws URISyntaxException {
        log.debug("REST request to update Vehicle : {}, {}", id, vehicle);

        Vehicle result = vehiclesRepo.save(vehicle);
        return ResponseEntity.ok(result);
    }

    /**
     * {@code PATCH  /vehicles/:id} : Partial updates given fields of an existing
     * vehicle, field will ignore if it is null
     */
    @PatchMapping(value = "/vehicles/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Vehicle> partialUpdateVehicle(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody Vehicle vehicle) throws URISyntaxException {
        log.debug("REST request to partial update Vehicle partially : {}, {}", id, vehicle);
        Optional<Vehicle> result = vehiclesRepo
                .findById(vehicle.getId())
                .map(existingVehicle -> {
                    if (vehicle.getMake() != null) {
                        existingVehicle.setMake(vehicle.getMake());
                    }
                    if (vehicle.getModel() != null) {
                        existingVehicle.setModel(vehicle.getModel());
                    }
                    if (vehicle.getLicenseNumber() != null) {
                        existingVehicle.setLicenseNumber(vehicle.getLicenseNumber());
                    }
                    if (vehicle.getMileage() != null) {
                        existingVehicle.setMileage(vehicle.getMileage());
                    }
                    if (vehicle.getVehicleYear() != null) {
                        existingVehicle.setVehicleYear(vehicle.getVehicleYear());
                    }

                    return existingVehicle;
                })
                .map(vehiclesRepo::save);

        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, vehicle.getId().toString()));
    }

    /**
     * {@code GET  /vehicles} : get all the vehicles.
     */
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        log.debug("REST request to get all Vehicles");
        return vehiclesRepo.findAll();
    }

    /**
     * {@code GET  /vehicles/:id} : get the "id" vehicle.
     */
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id) {
        log.debug("REST request to get Vehicle : {}", id);
        Optional<Vehicle> vehicle = vehiclesRepo.findById(id);
        return ResponseUtil.wrapOrNotFound(vehicle);
    }

    /**
     * {@code DELETE  /vehicles/:id} : delete the "id" vehicle.
     */
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        log.debug("REST request to delete Vehicle : {}", id);
        vehiclesRepo.deleteById(id);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
                .build();
    }
}
