package org.springframework.boot.actuate.autoconfigure.data.redis;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RedisHealthContributorAutoConfiguration}.
 */
public class RedisHealthContributorAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'redisHealthContributorAutoConfiguration'.
   */
  public static BeanDefinition getRedisHealthContributorAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisHealthContributorAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(RedisHealthContributorAutoConfiguration::new);
    return beanDefinition;
  }
}
