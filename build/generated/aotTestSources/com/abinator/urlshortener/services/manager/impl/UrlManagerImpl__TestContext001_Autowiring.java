package com.abinator.urlshortener.services.manager.impl;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UrlManagerImpl}.
 */
public class UrlManagerImpl__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UrlManagerImpl apply(RegisteredBean registeredBean, UrlManagerImpl instance) {
    AutowiredFieldValueResolver.forRequiredField("redisTemplate").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
