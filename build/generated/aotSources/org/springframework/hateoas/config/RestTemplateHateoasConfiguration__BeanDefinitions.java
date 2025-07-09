package org.springframework.hateoas.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RestTemplateHateoasConfiguration}.
 */
public class RestTemplateHateoasConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'restTemplateHateoasConfiguration'.
   */
  public static BeanDefinition getRestTemplateHateoasConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestTemplateHateoasConfiguration.class);
    beanDefinition.setInstanceSupplier(RestTemplateHateoasConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'hypermediaRestTemplateBeanPostProcessor'.
   */
  private static BeanInstanceSupplier<RestTemplateHateoasConfiguration.HypermediaRestTemplateBeanPostProcessor> getHypermediaRestTemplateBeanPostProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RestTemplateHateoasConfiguration.HypermediaRestTemplateBeanPostProcessor>forFactoryMethod(RestTemplateHateoasConfiguration.class, "hypermediaRestTemplateBeanPostProcessor", ObjectFactory.class)
            .withGenerator((registeredBean, args) -> RestTemplateHateoasConfiguration.hypermediaRestTemplateBeanPostProcessor(args.get(0)));
  }

  /**
   * Get the bean definition for 'hypermediaRestTemplateBeanPostProcessor'.
   */
  public static BeanDefinition getHypermediaRestTemplateBeanPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestTemplateHateoasConfiguration.class);
    beanDefinition.setTargetType(RestTemplateHateoasConfiguration.HypermediaRestTemplateBeanPostProcessor.class);
    beanDefinition.setInstanceSupplier(getHypermediaRestTemplateBeanPostProcessorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'hypermediaRestTemplateConfigurer'.
   */
  private static BeanInstanceSupplier<HypermediaRestTemplateConfigurer> getHypermediaRestTemplateConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HypermediaRestTemplateConfigurer>forFactoryMethod(RestTemplateHateoasConfiguration.class, "hypermediaRestTemplateConfigurer", WebConverters.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RestTemplateHateoasConfiguration.class).hypermediaRestTemplateConfigurer(args.get(0)));
  }

  /**
   * Get the bean definition for 'hypermediaRestTemplateConfigurer'.
   */
  public static BeanDefinition getHypermediaRestTemplateConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HypermediaRestTemplateConfigurer.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setInstanceSupplier(getHypermediaRestTemplateConfigurerInstanceSupplier());
    return beanDefinition;
  }
}
