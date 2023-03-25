package com.hlopez.demoapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hlopez.demoapi.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByStatus(String status);
}
