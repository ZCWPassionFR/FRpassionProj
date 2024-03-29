package com.fairrepair.fairrepair.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fairrepair.fairrepair.Model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

}
