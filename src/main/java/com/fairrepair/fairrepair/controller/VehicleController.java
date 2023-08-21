package com.fairrepair.fairrepair.controller;

import com.fairrepair.fairrepair.Model.Vehicle;
import com.fairrepair.fairrepair.repository.VehiclesRepo;
import com.fairrepair.fairrepair.service.VehicleServ;

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

    private final VehicleServ vehicleServ;

    public VehicleController(VehicleServ vehicleServ) {
        this.vehicleServ = vehicleServ;
    }

    /**
     * {@code POST  /vehicles} : Create a new vehicle.
     */
    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) throws URISyntaxException {
        log.debug("REST request to save Vehicle : {}", vehicle);
        Vehicle result = vehicleServ.save(vehicle);
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
        Vehicle result = vehicleServ.save(vehicle);
        return ResponseEntity.ok(result);
    }

    /**
     * {@code GET  /vehicles} : get all the vehicles.
     */
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        log.debug("REST request to get all Vehicles");
        return vehicleServ.findAll();
    }

    /**
     * {@code GET  /vehicles/:id} : get the "id" vehicle.
     */
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id) {
        log.debug("REST request to get Vehicle : {}", id);
        Optional<Vehicle> vehicle = vehicleServ.findById(id);
        return ResponseEntity.ok(vehicle.get());
    }

    /**
     * {@code DELETE  /vehicles/:id} : delete the "id" vehicle.
     */
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        log.debug("REST request to delete Vehicle : {}", id);
        vehicleServ.deleteById(id);
        return ResponseEntity.noContent().build();
        // creates 204 No content status code
    }
}
