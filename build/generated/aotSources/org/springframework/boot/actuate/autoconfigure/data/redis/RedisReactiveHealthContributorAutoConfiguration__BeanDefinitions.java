package org.springframework.boot.actuate.autoconfigure.data.redis;

import java.util.Map;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.health.ReactiveHealthContributor;

/**
 * Bean definitions for {@link RedisReactiveHealthContributorAutoConfiguration}.
 */
public class RedisReactiveHealthContributorAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.actuate.autoconfigure.data.redis.RedisReactiveHealthContributorAutoConfiguration'.
   */
  private static BeanInstanceSupplier<RedisReactiveHealthContributorAutoConfiguration> getRedisReactiveHealthContributorAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RedisReactiveHealthContributorAutoConfiguration>forConstructor(Map.class)
            .withGenerator((registeredBean, args) -> new RedisReactiveHealthContributorAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'redisReactiveHealthContributorAutoConfiguration'.
   */
  public static BeanDefinition getRedisReactiveHealthContributorAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisReactiveHealthContributorAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getRedisReactiveHealthContributorAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redisHealthContributor'.
   */
  private static BeanInstanceSupplier<ReactiveHealthContributor> getRedisHealthContributorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveHealthContributor>forFactoryMethod(RedisReactiveHealthContributorAutoConfiguration.class, "redisHealthContributor")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(RedisReactiveHealthContributorAutoConfiguration.class).redisHealthContributor());
  }

  /**
   * Get the bean definition for 'redisHealthContributor'.
   */
  public static BeanDefinition getRedisHealthContributorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveHealthContributor.class);
    beanDefinition.setInstanceSupplier(getRedisHealthContributorInstanceSupplier());
    return beanDefinition;
  }
}
