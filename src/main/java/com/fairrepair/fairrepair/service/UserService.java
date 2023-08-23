package com.fairrepair.fairrepair.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fairrepair.fairrepair.dto.UserDTO;
import com.fairrepair.fairrepair.Model.User;
import com.fairrepair.fairrepair.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    
    public User save(User user) {
        return userRepo.save(user);
    }

    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }


    public @Valid User updateUser(@Valid User user) {
        return userRepo.save(user);
    }
}
