package com.web.server.service.impl;

import com.web.server.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Component
public class ImageServiceImpl implements ImageService {

  // Move image to projecfolders
  // Give that path
  @Override
  public Resource getGifImage() throws IOException {
    File file = new File("/home/amishra/repo/anurag/awesome.webp");

    Path path = Paths.get(file.getAbsolutePath());

    return new ByteArrayResource(Files.readAllBytes(path));

  }
}
