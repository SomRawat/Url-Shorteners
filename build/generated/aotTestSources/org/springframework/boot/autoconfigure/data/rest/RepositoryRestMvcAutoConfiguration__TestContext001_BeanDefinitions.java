package org.springframework.boot.autoconfigure.data.rest;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RepositoryRestMvcAutoConfiguration}.
 */
public class RepositoryRestMvcAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'repositoryRestMvcAutoConfiguration'.
   */
  public static BeanDefinition getRepositoryRestMvcAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryRestMvcAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(RepositoryRestMvcAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springBootRepositoryRestConfigurer'.
   */
  private static BeanInstanceSupplier<SpringBootRepositoryRestConfigurer> getSpringBootRepositoryRestConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringBootRepositoryRestConfigurer>forFactoryMethod(RepositoryRestMvcAutoConfiguration.class, "springBootRepositoryRestConfigurer", ObjectProvider.class, RepositoryRestProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RepositoryRestMvcAutoConfiguration.class).springBootRepositoryRestConfigurer(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'springBootRepositoryRestConfigurer'.
   */
  public static BeanDefinition getSpringBootRepositoryRestConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringBootRepositoryRestConfigurer.class);
    beanDefinition.setInstanceSupplier(getSpringBootRepositoryRestConfigurerInstanceSupplier());
    return beanDefinition;
  }
}
