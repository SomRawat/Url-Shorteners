package org.springframework.boot.actuate.autoconfigure.metrics.redis;

import io.lettuce.core.metrics.MicrometerOptions;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.data.redis.ClientResourcesBuilderCustomizer;

/**
 * Bean definitions for {@link LettuceMetricsAutoConfiguration}.
 */
public class LettuceMetricsAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'lettuceMetricsAutoConfiguration'.
   */
  public static BeanDefinition getLettuceMetricsAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LettuceMetricsAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(LettuceMetricsAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'micrometerOptions'.
   */
  private static BeanInstanceSupplier<MicrometerOptions> getMicrometerOptionsInstanceSupplier() {
    return BeanInstanceSupplier.<MicrometerOptions>forFactoryMethod(LettuceMetricsAutoConfiguration.class, "micrometerOptions")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(LettuceMetricsAutoConfiguration.class).micrometerOptions());
  }

  /**
   * Get the bean definition for 'micrometerOptions'.
   */
  public static BeanDefinition getMicrometerOptionsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MicrometerOptions.class);
    beanDefinition.setInstanceSupplier(getMicrometerOptionsInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'lettuceMetrics'.
   */
  private static BeanInstanceSupplier<ClientResourcesBuilderCustomizer> getLettuceMetricsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ClientResourcesBuilderCustomizer>forFactoryMethod(LettuceMetricsAutoConfiguration.class, "lettuceMetrics", MeterRegistry.class, MicrometerOptions.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(LettuceMetricsAutoConfiguration.class).lettuceMetrics(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'lettuceMetrics'.
   */
  public static BeanDefinition getLettuceMetricsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientResourcesBuilderCustomizer.class);
    beanDefinition.setInstanceSupplier(getLettuceMetricsInstanceSupplier());
    return beanDefinition;
  }
}
