package com.abinator.urlshortener.services.manager.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UrlManagerImpl}.
 */
public class UrlManagerImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'urlManagerImpl'.
   */
  public static BeanDefinition getUrlManagerImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UrlManagerImpl.class);
    InstanceSupplier<UrlManagerImpl> instanceSupplier = InstanceSupplier.using(UrlManagerImpl::new);
    instanceSupplier = instanceSupplier.andThen(UrlManagerImpl__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
