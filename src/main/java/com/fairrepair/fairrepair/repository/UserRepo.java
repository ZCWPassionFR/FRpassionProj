package com.fairrepair.fairrepair.repository;

import org.springframework.data.repository.CrudRepository;
import com.fairrepair.fairrepair.model.User;

public interface UserRepo extends CrudRepository<User, Long> {

}
