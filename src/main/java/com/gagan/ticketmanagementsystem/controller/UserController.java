package com.gagan.ticketmanagementsystem.controller;

import com.gagan.ticketmanagementsystem.entity.User;
import com.gagan.ticketmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping("{/id}")
    public String deleteUser(@PathVariable Integer id){
        return "User with ID " + id + "has been deleted successfully";
    }
}