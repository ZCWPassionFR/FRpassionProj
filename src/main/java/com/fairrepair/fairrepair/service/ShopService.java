package com.fairrepair.fairrepair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fairrepair.fairrepair.Model.Shop;
import com.fairrepair.fairrepair.repository.ShopRepo;

@Service
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
