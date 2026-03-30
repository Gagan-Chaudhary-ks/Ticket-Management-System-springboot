package com.gagan.ticketmanagementsystem.repository;

import com.gagan.ticketmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}