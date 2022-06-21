package org.tnmk.practicespringjpa.pro00simpleconnect.simple;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.tnmk.practicespringjpa.pro00simpleconnect.simple.event.Event;

import java.io.UnsupportedEncodingException;

@Component
@Slf4j
@RequiredArgsConstructor
public class SimpleEventListener {

  private final ObjectMapper objectMapper;

  @JmsListener(destination = "${simple.topic}", containerFactory = "topicJmsListenerContainerFactory",
      subscription = "${simple.subscription}")
  public void receiveEvent(Message<Object> message) throws UnsupportedEncodingException, JsonProcessingException {
    log.info("Received event as bytes: {}", message);
    String json = toText((byte[]) message.getPayload());
    log.info("Message payload as string: {}", json);
    Event event = objectMapper.readValue(json, Event.class);
    log.info("Message payload as object: {}", event);
  }

  public static String toText(byte[] bytes) throws UnsupportedEncodingException {
    String text = new String(bytes, "UTF-8");
    log.info("print: " + text);
    return text;
  }
}