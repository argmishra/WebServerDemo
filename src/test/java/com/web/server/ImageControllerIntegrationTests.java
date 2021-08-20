package com.web.server;

import com.web.server.repo.ImageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WebServerApplication.class)
@AutoConfigureMockMvc
public class ImageControllerIntegrationTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ImageRepository imageRepository;

  @Test
  public void findFileByPath_found() throws Exception {
    mockMvc.perform(get("/image").
        contentType(MediaType.APPLICATION_JSON)).
        andExpect(status().isOk());

    Assertions.assertEquals(1,imageRepository.findAll().size());
  }
}
