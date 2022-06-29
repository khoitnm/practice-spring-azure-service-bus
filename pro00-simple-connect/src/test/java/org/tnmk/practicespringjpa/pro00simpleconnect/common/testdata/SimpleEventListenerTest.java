package org.tnmk.practicespringjpa.pro00simpleconnect.common.testdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.tnmk.practicespringjpa.pro00simpleconnect.simple.SimpleEventListener;
import org.tnmk.practicespringjpa.pro00simpleconnect.simple.event.Event;
import org.tnmk.practicespringjpa.pro00simpleconnect.testinfra.BaseSpringTest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class SimpleEventListenerTest extends BaseSpringTest {
  @Autowired
  private SimpleEventListener simpleEventListener;

  @Test
  public void test() throws UnsupportedEncodingException, JsonProcessingException {
    String myString = "{\"eventType\": \"enable\"}";
    Message<byte[]> message = new GenericMessage<>(myString.getBytes(StandardCharsets.UTF_8));
    simpleEventListener.receiveEvent(message);
  }
}