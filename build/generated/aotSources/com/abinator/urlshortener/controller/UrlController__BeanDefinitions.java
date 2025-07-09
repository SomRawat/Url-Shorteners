package com.abinator.urlshortener.controller;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UrlController}.
 */
public class UrlController__BeanDefinitions {
  /**
   * Get the bean definition for 'urlController'.
   */
  public static BeanDefinition getUrlControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UrlController.class);
    InstanceSupplier<UrlController> instanceSupplier = InstanceSupplier.using(UrlController::new);
    instanceSupplier = instanceSupplier.andThen(UrlController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
