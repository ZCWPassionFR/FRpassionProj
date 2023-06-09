package com.fairrepair.fairrepair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fairrepair.fairrepair.dto.UserDTO;
import com.fairrepair.fairrepair.model.User;
import com.fairrepair.fairrepair.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    public User save(UserDTO user) {
        return userRepo.save(user);
    }

    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }
    // public void save(UserDTO userDto){
    // userRepo.save(userDto);
    // }
}
