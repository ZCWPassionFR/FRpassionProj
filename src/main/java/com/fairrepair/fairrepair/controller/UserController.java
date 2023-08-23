package com.fairrepair.fairrepair.controller;

import com.fairrepair.fairrepair.config.Constants;
import com.fairrepair.fairrepair.Model.User;
import com.fairrepair.fairrepair.service.UserService;
import com.fairrepair.fairrepair.dto.UserDTO;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/admin")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        // this.userRepository = userRepository;
    }

    // @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        log.debug("REST request to save User : {}", user);
        User newUser = userService.save(user);
        // User user = userService.save(user);
        return ResponseEntity.ok().body(newUser);
    }

    // @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/users")
    // @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        log.debug("REST request to update User : {}", user);
        // Optional<User> existingUser = userRepository.findOneByEmailIgnoreCase(user.getEmail());
        // existingUser = userRepository.findOneByLogin(user.getLogin().toLowerCase());
        @Valid User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * {@code GET /admin/users} : get all users with all the details - calling this
     * are only allowed for the administrators.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         all users.
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        log.debug("REST request to get all User for an admin");
        List<User> list = userService.findAll();
        return ResponseEntity.ok(list);
    }

    /**
     * @param login the login of the user to find.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the "login" user, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/users/{login}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        log.debug("REST request to get User : {}", id);
        return ResponseEntity.ok(userService.findById(id));
    }

    /**
     * @param login the login of the user to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/users/{login}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.debug("REST request to delete User: {}", id);
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
