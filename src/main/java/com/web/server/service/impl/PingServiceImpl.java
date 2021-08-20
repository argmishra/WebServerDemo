package com.web.server.service.impl;

import com.web.server.service.PingService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class PingServiceImpl implements PingService {

  @Override
  public Boolean findFileByPath(String path){
    return new File(path).isFile();
  }
}
