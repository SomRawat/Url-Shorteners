package com.abinator.urlshortener.config;

import com.abinator.urlshortener.entry.Url;
import java.lang.String;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.core.ResolvableType;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Bean definitions for {@link RedisConfiguration}.
 */
public class RedisConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'redisConfiguration'.
   */
  public static BeanDefinition getRedisConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisConfiguration.class);
    beanDefinition.setTargetType(RedisConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(RedisConfiguration.class);
    InstanceSupplier<RedisConfiguration> instanceSupplier = InstanceSupplier.using(RedisConfiguration$$SpringCGLIB$$0::new);
    instanceSupplier = instanceSupplier.andThen(RedisConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redisTemplate'.
   */
  private static BeanInstanceSupplier<RedisTemplate> getRedisTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<RedisTemplate>forFactoryMethod(RedisConfiguration.class, "redisTemplate")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(RedisConfiguration.class).redisTemplate());
  }

  /**
   * Get the bean definition for 'redisTemplate'.
   */
  public static BeanDefinition getRedisTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisTemplate.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(RedisTemplate.class, String.class, Url.class));
    beanDefinition.setInstanceSupplier(getRedisTemplateInstanceSupplier());
    return beanDefinition;
  }
}
