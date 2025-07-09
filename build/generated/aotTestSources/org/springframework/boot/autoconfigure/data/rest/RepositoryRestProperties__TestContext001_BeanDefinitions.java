package org.springframework.boot.autoconfigure.data.rest;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RepositoryRestProperties}.
 */
public class RepositoryRestProperties__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'repositoryRestProperties'.
   */
  public static BeanDefinition getRepositoryRestPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryRestProperties.class);
    beanDefinition.setInstanceSupplier(RepositoryRestProperties::new);
    return beanDefinition;
  }
}
