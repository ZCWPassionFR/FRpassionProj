package com.fairrepair.fairrepair.controller;

import com.fairrepair.fairrepair.model.Appointments;
import com.fairrepair.fairrepair.service.AppointmentService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.tomcat.util.http.HeaderUtil;
import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Transactional
public class AppointmentController {
    private final Logger log = LoggerFactory.getLogger(AppointmentController.class);
    private static final String ENTITY_NAME = "appointment";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointments")
    public ResponseEntity<Appointments> createAppointment(@RequestBody Appointments appointment)
            throws URISyntaxException {
        log.debug("REST request to save Appointment : {}", appointment);

        Appointments result = appointmentService.save(appointment);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Appointments> updateAppointment(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody Appointments appointment) throws URISyntaxException {
        log.debug("REST request to update Appointment : {}, {}", id, appointment);
        // if (appointment.getId() == null) {
        // throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        // }
        // if (!Objects.equals(id, appointment.getId())) {
        // throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        // }

        // if (!appointmentRepository.existsById(id)) {
        // throw new BadRequestAlertException("Entity not found", ENTITY_NAME,
        // "idnotfound");
        // }
        Appointments result = appointmentService.save(appointment);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/appointments")
    public List<Appointments> getAllAppointments() {
        log.debug("REST request to get all Appointments");
        return appointmentService.findAll();
    }

    /**
     * {@code GET  /appointments/:id} : get the "id" appointment.
     *
     * @param id the id of the appointment to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the appointment, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointments> getAppointment(@PathVariable Long id) {
        log.debug("REST request to get Appointment : {}", id);
        Appointments appointment = appointmentService.findById(id);
        return ResponseEntity.ok(appointment);
    }

    /**
     * {@code DELETE  /appointments/:id} : delete the "id" appointment.
     *
     * @param id the id of the appointment to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        log.debug("REST request to delete Appointment : {}", id);
        appointmentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
