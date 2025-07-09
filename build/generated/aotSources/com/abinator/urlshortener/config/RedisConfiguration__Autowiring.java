package com.abinator.urlshortener.config;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RedisConfiguration}.
 */
public class RedisConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RedisConfiguration apply(RegisteredBean registeredBean,
      RedisConfiguration instance) {
    instance.objectMapper = AutowiredFieldValueResolver.forRequiredField("objectMapper").resolve(registeredBean);
    instance.connectionFactory = AutowiredFieldValueResolver.forRequiredField("connectionFactory").resolve(registeredBean);
    return instance;
  }
}
