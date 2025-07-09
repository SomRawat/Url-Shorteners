package org.springframework.hateoas.config;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.MessageResolver;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.hateoas.server.core.AnnotationLinkRelationProvider;
import org.springframework.hateoas.server.core.DelegatingLinkRelationProvider;
import org.springframework.plugin.core.OrderAwarePluginRegistry;
import org.springframework.plugin.core.PluginRegistry;

/**
 * Bean definitions for {@link HateoasConfiguration}.
 */
public class HateoasConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'hateoasConfiguration'.
   */
  public static BeanDefinition getHateoasConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HateoasConfiguration.class);
    InstanceSupplier<HateoasConfiguration> instanceSupplier = InstanceSupplier.using(HateoasConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(HateoasConfiguration__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'messageResolver'.
   */
  private static BeanInstanceSupplier<MessageResolver> getMessageResolverInstanceSupplier() {
    return BeanInstanceSupplier.<MessageResolver>forFactoryMethod(HateoasConfiguration.class, "messageResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HateoasConfiguration.class).messageResolver());
  }

  /**
   * Get the bean definition for 'messageResolver'.
   */
  public static BeanDefinition getMessageResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MessageResolver.class);
    beanDefinition.setInstanceSupplier(getMessageResolverInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'hypermediaWebMvcConverters'.
   */
  private static BeanInstanceSupplier<WebConverters> getHypermediaWebMvcConvertersInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebConverters>forFactoryMethod(HateoasConfiguration.class, "hypermediaWebMvcConverters", ObjectProvider.class, List.class, Optional.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HateoasConfiguration.class).hypermediaWebMvcConverters(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'hypermediaWebMvcConverters'.
   */
  public static BeanDefinition getHypermediaWebMvcConvertersBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebConverters.class);
    beanDefinition.setInstanceSupplier(getHypermediaWebMvcConvertersInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'defaultRelProvider'.
   */
  private static BeanInstanceSupplier<LinkRelationProvider> getDefaultRelProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<LinkRelationProvider>forFactoryMethod(HateoasConfiguration.class, "defaultRelProvider")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HateoasConfiguration.class).defaultRelProvider());
  }

  /**
   * Get the bean definition for 'defaultRelProvider'.
   */
  public static BeanDefinition getDefaultRelProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LinkRelationProvider.class);
    beanDefinition.setInstanceSupplier(getDefaultRelProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'annotationRelProvider'.
   */
  private static BeanInstanceSupplier<AnnotationLinkRelationProvider> getAnnotationRelProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AnnotationLinkRelationProvider>forFactoryMethod(HateoasConfiguration.class, "annotationRelProvider")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HateoasConfiguration.class).annotationRelProvider());
  }

  /**
   * Get the bean definition for 'annotationRelProvider'.
   */
  public static BeanDefinition getAnnotationRelProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AnnotationLinkRelationProvider.class);
    beanDefinition.setInstanceSupplier(getAnnotationRelProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for '_relProvider'.
   */
  private static BeanInstanceSupplier<DelegatingLinkRelationProvider> getRelProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DelegatingLinkRelationProvider>forFactoryMethod(HateoasConfiguration.class, "_relProvider", PluginRegistry.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HateoasConfiguration.class)._relProvider(args.get(0)));
  }

  /**
   * Get the bean definition for '_relProvider'.
   */
  public static BeanDefinition getRelProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DelegatingLinkRelationProvider.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getRelProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'relProviderPluginRegistry'.
   */
  private static BeanInstanceSupplier<OrderAwarePluginRegistry> getRelProviderPluginRegistryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OrderAwarePluginRegistry>forFactoryMethod(HateoasConfiguration.class, "relProviderPluginRegistry", ApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HateoasConfiguration.class).relProviderPluginRegistry(args.get(0)));
  }

  /**
   * Get the bean definition for 'relProviderPluginRegistry'.
   */
  public static BeanDefinition getRelProviderPluginRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OrderAwarePluginRegistry.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(OrderAwarePluginRegistry.class, LinkRelationProvider.class, LinkRelationProvider.LookupContext.class));
    beanDefinition.setInstanceSupplier(getRelProviderPluginRegistryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'linkDiscoverers'.
   */
  private static BeanInstanceSupplier<LinkDiscoverers> getLinkDiscoverersInstanceSupplier() {
    return BeanInstanceSupplier.<LinkDiscoverers>forFactoryMethod(HateoasConfiguration.class, "linkDiscoverers", PluginRegistry.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HateoasConfiguration.class).linkDiscoverers(args.get(0)));
  }

  /**
   * Get the bean definition for 'linkDiscoverers'.
   */
  public static BeanDefinition getLinkDiscoverersBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LinkDiscoverers.class);
    beanDefinition.setInstanceSupplier(getLinkDiscoverersInstanceSupplier());
    return beanDefinition;
  }
}
