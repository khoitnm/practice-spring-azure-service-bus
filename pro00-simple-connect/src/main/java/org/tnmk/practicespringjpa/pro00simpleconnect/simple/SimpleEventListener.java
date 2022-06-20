package org.tnmk.practicespringjpa.pro00simpleconnect.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleEventListener {

  @JmsListener(destination = "${simple.topic}", containerFactory = "topicJmsListenerContainerFactory",
      subscription = "${simple.subscription}")
  public void receiveMessage(String message) {
    log.info("Received message: {}", message);
  }
}