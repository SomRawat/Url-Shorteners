package org.springframework.hateoas.config;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.core.DelegatingEntityLinks;
import org.springframework.plugin.core.OrderAwarePluginRegistry;
import org.springframework.plugin.core.PluginRegistry;

/**
 * Bean definitions for {@link EntityLinksConfiguration}.
 */
public class EntityLinksConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'entityLinksPluginRegistry'.
   */
  private static BeanInstanceSupplier<OrderAwarePluginRegistry> getEntityLinksPluginRegistryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OrderAwarePluginRegistry>forFactoryMethod(EntityLinksConfiguration.class, "entityLinksPluginRegistry", ApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EntityLinksConfiguration.class).entityLinksPluginRegistry(args.get(0)));
  }

  /**
   * Get the bean definition for 'entityLinksPluginRegistry'.
   */
  public static BeanDefinition getEntityLinksPluginRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OrderAwarePluginRegistry.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(OrderAwarePluginRegistry.class, ResolvableType.forClass(EntityLinks.class), ResolvableType.forClass(Class.class)));
    beanDefinition.setInstanceSupplier(getEntityLinksPluginRegistryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'delegatingEntityLinks'.
   */
  private static BeanInstanceSupplier<DelegatingEntityLinks> getDelegatingEntityLinksInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DelegatingEntityLinks>forFactoryMethod(EntityLinksConfiguration.class, "delegatingEntityLinks", PluginRegistry.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(EntityLinksConfiguration.class).delegatingEntityLinks(args.get(0)));
  }

  /**
   * Get the bean definition for 'delegatingEntityLinks'.
   */
  public static BeanDefinition getDelegatingEntityLinksBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DelegatingEntityLinks.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getDelegatingEntityLinksInstanceSupplier());
    return beanDefinition;
  }
}
