package org.tnmk.practicespringjpa.pro00simpleconnect.simple.event;

import lombok.Data;

/**
 * This class represent the structure of message that we receive from Service Bus
 */
@Data
public class Event {
  private String sampleField;
}
