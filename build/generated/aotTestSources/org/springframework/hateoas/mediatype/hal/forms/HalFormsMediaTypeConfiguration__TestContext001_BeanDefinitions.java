package org.springframework.hateoas.mediatype.hal.forms;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.mediatype.MessageResolver;
import org.springframework.hateoas.server.core.DelegatingLinkRelationProvider;

/**
 * Bean definitions for {@link HalFormsMediaTypeConfiguration}.
 */
public class HalFormsMediaTypeConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.hateoas.mediatype.hal.forms.HalFormsMediaTypeConfiguration'.
   */
  private static BeanInstanceSupplier<HalFormsMediaTypeConfiguration> getHalFormsMediaTypeConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HalFormsMediaTypeConfiguration>forConstructor(DelegatingLinkRelationProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, MessageResolver.class, AbstractAutowireCapableBeanFactory.class)
            .withGenerator((registeredBean, args) -> new HalFormsMediaTypeConfiguration(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
  }

  /**
   * Get the bean definition for 'halFormsMediaTypeConfiguration'.
   */
  public static BeanDefinition getHalFormsMediaTypeConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HalFormsMediaTypeConfiguration.class);
    beanDefinition.setInstanceSupplier(getHalFormsMediaTypeConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'halFormsLinkDiscoverer'.
   */
  private static BeanInstanceSupplier<LinkDiscoverer> getHalFormsLinkDiscovererInstanceSupplier() {
    return BeanInstanceSupplier.<LinkDiscoverer>forFactoryMethod(HalFormsMediaTypeConfiguration.class, "halFormsLinkDiscoverer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HalFormsMediaTypeConfiguration.class).halFormsLinkDiscoverer());
  }

  /**
   * Get the bean definition for 'halFormsLinkDiscoverer'.
   */
  public static BeanDefinition getHalFormsLinkDiscovererBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LinkDiscoverer.class);
    beanDefinition.setInstanceSupplier(getHalFormsLinkDiscovererInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'halFormsTemplatePropertyWriter'.
   */
  private static BeanInstanceSupplier<HalFormsTemplatePropertyWriter> getHalFormsTemplatePropertyWriterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HalFormsTemplatePropertyWriter>forFactoryMethod(HalFormsMediaTypeConfiguration.class, "halFormsTemplatePropertyWriter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HalFormsMediaTypeConfiguration.class).halFormsTemplatePropertyWriter());
  }

  /**
   * Get the bean definition for 'halFormsTemplatePropertyWriter'.
   */
  public static BeanDefinition getHalFormsTemplatePropertyWriterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HalFormsTemplatePropertyWriter.class);
    beanDefinition.setInstanceSupplier(getHalFormsTemplatePropertyWriterInstanceSupplier());
    return beanDefinition;
  }
}
