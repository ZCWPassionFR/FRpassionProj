package com.fairrepair.fairrepair.controller;

import com.fairrepair.fairrepair.model.Appointments;
import com.fairrepair.fairrepair.repository.AppointmentsRepo;
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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link com.zcpassionfr.domain.Appointment}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class AppointmentController {

    private final Logger log = LoggerFactory.getLogger(AppointmentController.class);

    private static final String ENTITY_NAME = "appointment";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    private final AppointmentsRepo appointmentRepository;

    public AppointmentController(AppointmentsRepo appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * {@code POST  /appointments} : Create a new appointment.
     *
     * @param appointment the appointment to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new appointment, or with status {@code 400 (Bad Request)} if
     *         the appointment has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/appointments")
    public ResponseEntity<Appointments> createAppointment(@RequestBody Appointments appointment)
            throws URISyntaxException {
        log.debug("REST request to save Appointment : {}", appointment);
        // if (appointment.getId() != null) {
        // throw new BadRequestAlertException("A new appointment cannot already have an
        // ID", ENTITY_NAME, "idexists");
        // }
        Appointments result = appointmentRepository.save(appointment);
        return ResponseEntity.ok(result);
        // .created(new URI("/api/appointments/" + result.getId()))
        // .headers(HeaderUtil.createEntityCreationAlert(applicationName, false,
        // ENTITY_NAME,
        // result.getId().toString()))
        // .body(result);
    }

    /**
     * {@code PUT  /appointments/:id} : Updates an existing appointment.
     *
     * @param id          the id of the appointment to save.
     * @param appointment the appointment to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated appointment,
     *         or with status {@code 400 (Bad Request)} if the appointment is not
     *         valid,
     *         or with status {@code 500 (Internal Server Error)} if the appointment
     *         couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
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
        Appointments result = appointmentRepository.save(appointment);
        return ResponseEntity.ok(result);
    }

    /**
     * {@code PATCH  /appointments/:id} : Partial updates given fields of an
     * existing appointment, field will ignore if it is null
     *
     * @param id          the id of the appointment to save.
     * @param appointment the appointment to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated appointment,
     *         or with status {@code 400 (Bad Request)} if the appointment is not
     *         valid,
     *         or with status {@code 404 (Not Found)} if the appointment is not
     *         found,
     *         or with status {@code 500 (Internal Server Error)} if the appointment
     *         couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    // @PatchMapping(value = "/appointments/{id}", consumes = { "application/json",
    // "application/merge-patch+json" })
    // public ResponseEntity<Appointments> partialUpdateAppointment(
    // @PathVariable(value = "id", required = false) final Long id,
    // @RequestBody Appointments appointment) throws URISyntaxException {
    // log.debug("REST request to partial update Appointment partially : {}, {}",
    // id, appointment);
    // // if (appointment.getId() == null) {
    // // throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
    // // }
    // // if (!Objects.equals(id, appointment.getId())) {
    // // throw new BadRequestAlertException("Invalid ID", ENTITY_NAME,
    // "idinvalid");
    // // }

    // // if (!appointmentRepository.existsById(id)) {
    // // throw new BadRequestAlertException("Entity not found", ENTITY_NAME,
    // // "idnotfound");
    // // }

    // Optional<Appointments> result = appointmentRepository
    // .findById(appointment.getId())
    // .map(existingAppointment -> {
    // if (appointment.getTimeSlot() != null) {
    // existingAppointment.setTimeSlot(appointment.getTimeSlot());
    // }

    // return existingAppointment;
    // })
    // .map(appointmentRepository::save);

    // return ResponseUtil.wrapOrNotFound(
    // result);
    // // HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME,
    // // appointment.getId().toString()));
    // }

    /**
     * {@code GET  /appointments} : get all the appointments.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of appointments in body.
     */
    @GetMapping("/appointments")
    public List<Appointments> getAllAppointments() {
        log.debug("REST request to get all Appointments");
        return appointmentRepository.findAll();
    }

    /**
     * {@code GET  /appointments/:id} : get the "id" appointment.
     *
     * @param id the id of the appointment to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the appointment, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        log.debug("REST request to get Appointment : {}", id);
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(appointment);
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
        appointmentRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
                .build();
    }
}
