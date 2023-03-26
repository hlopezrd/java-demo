package com.hlopez.demoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlopez.demoapi.dao.UserRepository;
import com.hlopez.demoapi.dto.User;

@Service
public class UserService {
  @Autowired
  UserRepository dao;

  public List<User> getAll() {
    return dao.findAll();
  }

  public List<User> getByStatus(String status) {
    return dao.findByStatus(status);
  }
  
}
