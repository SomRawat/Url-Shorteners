package org.springframework.boot.autoconfigure.data.redis;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Bean definitions for {@link RedisAutoConfiguration}.
 */
public class RedisAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'redisAutoConfiguration'.
   */
  public static BeanDefinition getRedisAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(RedisAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redisConnectionDetails'.
   */
  private static BeanInstanceSupplier<PropertiesRedisConnectionDetails> getRedisConnectionDetailsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PropertiesRedisConnectionDetails>forFactoryMethod(RedisAutoConfiguration.class, "redisConnectionDetails", RedisProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RedisAutoConfiguration.class).redisConnectionDetails(args.get(0)));
  }

  /**
   * Get the bean definition for 'redisConnectionDetails'.
   */
  public static BeanDefinition getRedisConnectionDetailsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PropertiesRedisConnectionDetails.class);
    beanDefinition.setInstanceSupplier(getRedisConnectionDetailsInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'stringRedisTemplate'.
   */
  private static BeanInstanceSupplier<StringRedisTemplate> getStringRedisTemplateInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<StringRedisTemplate>forFactoryMethod(RedisAutoConfiguration.class, "stringRedisTemplate", RedisConnectionFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RedisAutoConfiguration.class).stringRedisTemplate(args.get(0)));
  }

  /**
   * Get the bean definition for 'stringRedisTemplate'.
   */
  public static BeanDefinition getStringRedisTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(StringRedisTemplate.class);
    beanDefinition.setInstanceSupplier(getStringRedisTemplateInstanceSupplier());
    return beanDefinition;
  }
}
