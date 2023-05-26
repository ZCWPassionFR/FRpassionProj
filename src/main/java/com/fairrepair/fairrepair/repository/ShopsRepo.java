package com.fairrepair.fairrepair.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fairrepair.fairrepair.model.Shops;

@Repository
public interface ShopsRepo extends CrudRepository<Shops, Long> {

}
