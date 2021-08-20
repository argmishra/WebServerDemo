package com.web.server.service.impl;

import com.web.server.model.Image;
import com.web.server.repo.ImageRepository;
import com.web.server.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class ImageServiceImpl implements ImageService {

  @Autowired
  private ImageRepository imageRepository;

  @Override
  @Transactional
  public Resource getGifImage() throws IOException {
    String location = System.getProperty("user.dir") + "/awesome.webp";
    File file = new File(location);
    Resource imageArray = this.getImage(file);

    imageRepository.save(Image.builder().message("File "+ file.getName() + " downloaded").build());

    return imageArray;
  }

  private Resource getImage(File file) throws IOException {
    Path path = Paths.get(file.getAbsolutePath());
    return new ByteArrayResource(Files.readAllBytes(path));
  }
}
