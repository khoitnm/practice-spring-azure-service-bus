package org.tnmk.practicespringjpa.pro00simpleconnect.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Slf4j
@Service
public class JmsErrorHandler implements ErrorHandler {

  @Override
  public void handleError(Throwable t) {
    log.error("Error in JmsListener : {}", t.getMessage(), t);
  }

}