package com.gagan.ticketmanagementsystem.service;

import com.gagan.ticketmanagementsystem.entity.User;
import com.gagan.ticketmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User u) {
        return userRepository.save(u);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}