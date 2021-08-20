package com.web.server.controller;

import com.web.server.service.PingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("ping")
@Slf4j
public class PingController {

  @Autowired
  private PingService pingService;

  @GetMapping
  public ResponseEntity<String> findFileByPath(@RequestParam(name = "path", required = true) String path) {
    log.info("Find {} file", path);
    Boolean result = pingService.findFileByPath(path);
    if(!result){
      throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
    }
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }



}
