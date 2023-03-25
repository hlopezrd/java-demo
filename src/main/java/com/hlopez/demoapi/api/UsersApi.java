package com.hlopez.demoapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hlopez.demoapi.dto.User;
import com.hlopez.demoapi.service.UserService;

@RestController
@RequestMapping("/api")
public class UsersApi {
  @Autowired
  UserService userService;

  @RequestMapping(value = "/v1/users", method = RequestMethod.GET)
  public List<User> getByStatus(@RequestParam(name = "status", required = false) String status) {
    if (status != null) {
      return userService.getByStatus(status);
    }
    return userService.getAll();
  }

}
