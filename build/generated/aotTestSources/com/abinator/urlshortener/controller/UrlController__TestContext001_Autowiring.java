package com.abinator.urlshortener.controller;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link UrlController}.
 */
public class UrlController__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static UrlController apply(RegisteredBean registeredBean, UrlController instance) {
    AutowiredFieldValueResolver.forRequiredField("urlManager").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
