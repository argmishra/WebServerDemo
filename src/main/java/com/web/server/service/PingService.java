package com.web.server.service;

import org.springframework.stereotype.Service;

@Service
public interface PingService {
  Boolean findFileByPath(String path);

}
