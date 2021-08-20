package com.web.server.controller;

import com.web.server.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("image")
@Slf4j
public class ImageController {

  @Autowired
  private ImageService imageService;

  @GetMapping
  public ResponseEntity<Resource> getGifImage() throws IOException {
    log.info("Get Image");
    Resource resource =  imageService.getGifImage();

    return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF).body(resource);
  }

}
