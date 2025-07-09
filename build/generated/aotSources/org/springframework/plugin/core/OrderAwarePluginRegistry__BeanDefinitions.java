package org.springframework.plugin.core;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.http.MediaType;
import org.springframework.plugin.core.support.PluginRegistryFactoryBean;

/**
 * Bean definitions for {@link OrderAwarePluginRegistry}.
 */
public class OrderAwarePluginRegistry__BeanDefinitions {
  /**
   * Get the bean definition for 'linkDiscovererRegistry'.
   */
  public static BeanDefinition getLinkDiscovererRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PluginRegistryFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(OrderAwarePluginRegistry.class, LinkDiscoverer.class, MediaType.class));
    beanDefinition.getPropertyValues().addPropertyValue("type", LinkDiscoverer.class);
    beanDefinition.setInstanceSupplier(PluginRegistryFactoryBean::new);
    return beanDefinition;
  }
}
