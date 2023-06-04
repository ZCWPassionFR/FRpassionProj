package com.fairrepair.fairrepair.controller;

import com.fairrepair.fairrepair.config.Constants;
import com.fairrepair.fairrepair.model.User;
import com.fairrepair.fairrepair.service.UserService;
import com.fairrepair.fairrepair.dto.UserDTO;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Collections;
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

    // private static final List<String> ALLOWED_ORDERED_PROPERTIES =
    // Collections.unmodifiableList(
    // Arrays.asList(
    // "id",
    // "login",
    // "firstName",
    // "lastName",
    // "email",
    // "activated",
    // "langKey",
    // "createdBy",
    // "createdDate",
    // "lastModifiedBy",
    // "lastModifiedDate"));

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    private UserService userService;

    // @Autowired
    // private final UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
        // this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", userDTO);
        User newUser = userService.save(userDTO);
        // User user = userService.save(user);
        return ResponseEntity.ok().body(newUser);
    }

    @PutMapping("/users")
    // @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<AdminUserDTO> updateUser(@Valid @RequestBody AdminUserDTO userDTO) {
        log.debug("REST request to update User : {}", userDTO);
        Optional<User> existingUser = userRepository.findOneByEmailIgnoreCase(userDTO.getEmail());
        existingUser = userRepository.findOneByLogin(userDTO.getLogin().toLowerCase());
        Optional<AdminUserDTO> updatedUser = userService.updateUser(userDTO);

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
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<List<AdminUserDTO>> getAllUsers(
            @org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get all User for an admin");
        if (!onlyContainsAllowedProperties(pageable)) {
            return ResponseEntity.badRequest().build();
        }

        final Page<AdminUserDTO> page = userService.getAllManagedUsers(pageable);
        HttpHeaders headers = PaginationUtil
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    private boolean onlyContainsAllowedProperties(Pageable pageable) {
        return pageable.getSort().stream().map(Sort.Order::getProperty).allMatch(ALLOWED_ORDERED_PROPERTIES::contains);
    }

    /**
     * {@code GET /admin/users/:login} : get the "login" user.
     *
     * @param login the login of the user to find.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the "login" user, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/users/{login}")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<AdminUserDTO> getUser(@PathVariable @Pattern(regexp = Constants.LOGIN_REGEX) String login) {
        log.debug("REST request to get User : {}", login);
        return ResponseUtil.wrapOrNotFound(userService.getUserWithAuthoritiesByLogin(login).map(AdminUserDTO::new));
    }

    /**
     * {@code DELETE /admin/users/:login} : delete the "login" User.
     *
     * @param login the login of the user to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/users/{login}")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<Void> deleteUser(@PathVariable @Pattern(regexp = Constants.LOGIN_REGEX) String login) {
        log.debug("REST request to delete User: {}", login);
        userService.deleteUser(login);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createAlert(applicationName, "A user is deleted with identifier " + login, login))
                .build();
    }
}
