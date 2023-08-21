package com.fairrepair.fairrepair.controller;

import com.fairrepair.fairrepair.Model.Shop;
import com.fairrepair.fairrepair.service.ShopService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
public class ShopController {

    private final Logger log = LoggerFactory.getLogger(ShopController.class);

    private static final String ENTITY_NAME = "shop";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/shops")
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) throws URISyntaxException {
        log.debug("REST request to save Shop : {}", shop);
        // if (shop.getId() != null) {
        // throw new BadRequestAlertException("A new shop cannot already have an ID",
        // ENTITY_NAME, "idexists");
        // }
        Shop result = shopService.save(shop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/shops/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable(value = "id", required = false) final Long id,
            @RequestBody Shop shop)
            throws URISyntaxException {
        log.debug("REST request to update Shop : {}, {}", id, shop);
        Shop result = shopService.save(shop);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/shops")
    public List<Shop> getAllShops() {
        log.debug("REST request to get all Shops");
        return shopService.findAll();
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable Long id) {
        log.debug("REST request to get Shop : {}", id);
        Shop shop = shopService.findById(id);
        return ResponseEntity.ok(shop);
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        log.debug("REST request to delete Shop : {}", id);
        shopService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}