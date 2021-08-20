package com.web.server;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.server.service.PingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WebServerApplication.class)
@AutoConfigureMockMvc
public class PingControllerIntegrationTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PingService pingService;

  ObjectMapper mapper = new ObjectMapper();

  @Test
  public void findFileByPath_found() throws Exception {
    Mockito.when(pingService.findFileByPath("found")).thenReturn(true);

    MvcResult mvcResult = mockMvc.perform(get("/ping").param("path", "found").
        contentType(MediaType.APPLICATION_JSON)).
        andExpect(status().isOk()).andReturn();

    Assertions.assertEquals("OK",mvcResult.getResponse().getContentAsString());
  }

  @Test
  public void findFileByPath_not_found() throws Exception {
    Mockito.when(pingService.findFileByPath("notfound")).thenReturn(false);

   mockMvc.perform(get("/ping").param("path", "notfound").
        contentType(MediaType.APPLICATION_JSON)).
        andExpect(status().is5xxServerError());
  }
}
