package com.web.server.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ImageService {
  Resource getGifImage() throws IOException;

}
