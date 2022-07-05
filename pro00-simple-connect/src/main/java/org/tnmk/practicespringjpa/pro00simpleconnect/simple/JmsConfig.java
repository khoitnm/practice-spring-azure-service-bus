package org.tnmk.practicespringjpa.pro00simpleconnect.simple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@EnableJms
public class JmsConfig {
  @Bean
  public DefaultJmsListenerContainerFactory customJmsListenerContainerFactory(
      // `topicJmsListenerContainerFactory` is a bean defined by spring-cloud-azure-autoconfigure.
      // We have to use it to consume messages from a topic.
      JmsListenerContainerFactory topicJmsListenerContainerFactory,
      JmsErrorHandler jmsErrorHandler
  ) {
    if (!(topicJmsListenerContainerFactory instanceof DefaultJmsListenerContainerFactory)) {
      throw new UnsupportedOperationException(
          "spring-cloud-azure-autoconfigure has changed its detailed implementation:"
              + "The bean `topicJmsListenerContainerFactory` is not an instead of DefaultJmsListenerContainerFactory anymore."
              + "Hence, this `customJmsListenerContainerFactory` configuration doesn't work.");
    }
    DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = (DefaultJmsListenerContainerFactory) topicJmsListenerContainerFactory;
    defaultJmsListenerContainerFactory.setErrorHandler(jmsErrorHandler);
    return defaultJmsListenerContainerFactory;
  }

}
