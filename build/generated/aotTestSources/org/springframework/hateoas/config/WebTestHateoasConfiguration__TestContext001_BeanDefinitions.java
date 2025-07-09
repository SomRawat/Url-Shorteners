package org.springframework.hateoas.config;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link WebTestHateoasConfiguration}.
 */
public class WebTestHateoasConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'webTestHateoasConfiguration'.
   */
  public static BeanDefinition getWebTestHateoasConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebTestHateoasConfiguration.class);
    beanDefinition.setInstanceSupplier(WebTestHateoasConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webTestClientConfigurer'.
   */
  private static BeanInstanceSupplier<HypermediaWebTestClientConfigurer> getWebTestClientConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HypermediaWebTestClientConfigurer>forFactoryMethod(WebTestHateoasConfiguration.class, "webTestClientConfigurer", ObjectProvider.class, List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebTestHateoasConfiguration.class).webTestClientConfigurer(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'webTestClientConfigurer'.
   */
  public static BeanDefinition getWebTestClientConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HypermediaWebTestClientConfigurer.class);
    beanDefinition.setLazyInit(true);
    beanDefinition.setInstanceSupplier(getWebTestClientConfigurerInstanceSupplier());
    return beanDefinition;
  }
}
