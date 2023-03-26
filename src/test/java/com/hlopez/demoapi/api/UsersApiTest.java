package com.hlopez.demoapi.api;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Sql({"classpath:empty/reset.sql", "classpath:init/user-data.sql"})
public class UsersApiTest {
  @Autowired
  private MockMvc mockMvc;

  
  @Test
  void should_return_all_users() throws Exception {
    this.mockMvc.perform(get("/api/v1/users"))
              .andDo(print())
              .andExpect(status().isOk())
              .andExpect(content().contentType(APPLICATION_JSON))
              .andExpect(jsonPath("$").isArray())
              .andExpect(jsonPath("$", hasSize(4)))
              .andExpect(jsonPath("$.[0].id").value(1))
              .andExpect(jsonPath("$.[1].id").value(2))
              .andExpect(jsonPath("$.[2].id").value(33))
              .andExpect(jsonPath("$.[3].id").value(44));
  }

  @Test
  void should_return_enabled_users() throws Exception {
    this.mockMvc.perform(get("/api/v1/users?status=enabled"))
              .andDo(print())
              .andExpect(status().isOk())
              .andExpect(content().contentType(APPLICATION_JSON))
              .andExpect(jsonPath("$").isArray())
              .andExpect(jsonPath("$", hasSize(2)))
              .andExpect(jsonPath("$.[0].id").value(1))
              .andExpect(jsonPath("$.[1].id").value(2));
  }

  @Test
  void should_return_disabled_users() throws Exception {
    this.mockMvc.perform(get("/api/v1/users?status=disabled"))
              .andDo(print())
              .andExpect(status().isOk())
              .andExpect(content().contentType(APPLICATION_JSON))
              .andExpect(jsonPath("$").isArray())
              .andExpect(jsonPath("$", hasSize(2)))
              .andExpect(jsonPath("$.[0].id").value(33))
              .andExpect(jsonPath("$.[1].id").value(44));
  }

}
