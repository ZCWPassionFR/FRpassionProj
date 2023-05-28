package com.fairrepair.fairrepair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fairrepair.fairrepair.model.Shop;
import com.fairrepair.fairrepair.repository.ShopRepo;

public class ShopService {

    @Autowired
    ShopRepo shopsRepo;

    public List<Shop> findAll() {
        return (List<Shop>) shopsRepo.findAll();
    }

    public Shop save(Shop shops) {
        return shopsRepo.save(shops);
    }

    public Shop findById(Long id) {
        return shopsRepo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        shopsRepo.deleteById(id);
    }
}
