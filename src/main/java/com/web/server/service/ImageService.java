package com.web.server.service;

import org.springframework.core.io.Resource;

import java.io.IOException;

public interface ImageService {
  Resource getGifImage() throws IOException;

}
