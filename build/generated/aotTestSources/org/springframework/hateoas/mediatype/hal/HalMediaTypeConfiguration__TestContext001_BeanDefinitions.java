package org.springframework.hateoas.mediatype.hal;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.mediatype.MessageResolver;
import org.springframework.hateoas.server.LinkRelationProvider;

/**
 * Bean definitions for {@link HalMediaTypeConfiguration}.
 */
public class HalMediaTypeConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.hateoas.mediatype.hal.HalMediaTypeConfiguration'.
   */
  private static BeanInstanceSupplier<HalMediaTypeConfiguration> getHalMediaTypeConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HalMediaTypeConfiguration>forConstructor(LinkRelationProvider.class, ObjectProvider.class, ObjectProvider.class, MessageResolver.class, AutowireCapableBeanFactory.class)
            .withGenerator((registeredBean, args) -> new HalMediaTypeConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'halMediaTypeConfiguration'.
   */
  public static BeanDefinition getHalMediaTypeConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HalMediaTypeConfiguration.class);
    beanDefinition.setInstanceSupplier(getHalMediaTypeConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'halLinkDisocoverer'.
   */
  private static BeanInstanceSupplier<LinkDiscoverer> getHalLinkDisocovererInstanceSupplier() {
    return BeanInstanceSupplier.<LinkDiscoverer>forFactoryMethod(HalMediaTypeConfiguration.class, "halLinkDisocoverer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HalMediaTypeConfiguration.class).halLinkDisocoverer());
  }

  /**
   * Get the bean definition for 'halLinkDisocoverer'.
   */
  public static BeanDefinition getHalLinkDisocovererBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LinkDiscoverer.class);
    beanDefinition.setInstanceSupplier(getHalLinkDisocovererInstanceSupplier());
    return beanDefinition;
  }
}
