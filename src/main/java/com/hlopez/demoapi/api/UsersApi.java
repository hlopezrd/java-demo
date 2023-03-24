package com.hlopez.demoapi.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hlopez.demoapi.dto.User;

@RestController
public class UsersApi {

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public User getById() {
    return new User(1L, "John", "Doe", "john@hlopez.com", "johndoe", "enabled");
  }
}
