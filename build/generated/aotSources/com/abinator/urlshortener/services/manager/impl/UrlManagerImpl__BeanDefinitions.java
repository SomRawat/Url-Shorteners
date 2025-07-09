package com.abinator.urlshortener.services.manager.impl;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Bean definitions for {@link UrlManagerImpl}.
 */
public class UrlManagerImpl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'urlManagerImpl'.
   */
  private static BeanInstanceSupplier<UrlManagerImpl> getUrlManagerImplInstanceSupplier() {
    return BeanInstanceSupplier.<UrlManagerImpl>forConstructor(RedisTemplate.class)
            .withGenerator((registeredBean, args) -> new UrlManagerImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'urlManagerImpl'.
   */
  public static BeanDefinition getUrlManagerImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UrlManagerImpl.class);
    beanDefinition.setInstanceSupplier(getUrlManagerImplInstanceSupplier());
    return beanDefinition;
  }
}
