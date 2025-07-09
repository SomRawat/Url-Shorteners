package com.abinator.urlshortener.controller;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Bean definitions for {@link AnalyticsController}.
 */
public class AnalyticsController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'analyticsController'.
   */
  private static BeanInstanceSupplier<AnalyticsController> getAnalyticsControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AnalyticsController>forConstructor(RedisTemplate.class)
            .withGenerator((registeredBean, args) -> new AnalyticsController(args.get(0)));
  }

  /**
   * Get the bean definition for 'analyticsController'.
   */
  public static BeanDefinition getAnalyticsControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AnalyticsController.class);
    beanDefinition.setInstanceSupplier(getAnalyticsControllerInstanceSupplier());
    return beanDefinition;
  }
}
