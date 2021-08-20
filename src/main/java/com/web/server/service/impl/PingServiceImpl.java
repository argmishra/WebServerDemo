package com.web.server.service.impl;

import com.web.server.service.PingService;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PingServiceImpl implements PingService {

  @Override
  public Boolean findFileByPath(String path){
    return new File(path).isFile();
  }
}
