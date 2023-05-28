package com.fairrepair.fairrepair.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fairrepair.fairrepair.model.Shop;

@Repository
public interface ShopRepo extends CrudRepository<Shop, Long> {

}
