package org.springframework.hateoas.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.hateoas.server.core.ControllerEntityLinksFactoryBean;

/**
 * Bean definitions for {@link WebMvcEntityLinksConfiguration}.
 */
public class WebMvcEntityLinksConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webMvcEntityLinksConfiguration'.
   */
  public static BeanDefinition getWebMvcEntityLinksConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebMvcEntityLinksConfiguration.class);
    beanDefinition.setInstanceSupplier(WebMvcEntityLinksConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webMvcEntityLinks'.
   */
  private static BeanInstanceSupplier<ControllerEntityLinksFactoryBean> getWebMvcEntityLinksInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ControllerEntityLinksFactoryBean>forFactoryMethod(WebMvcEntityLinksConfiguration.class, "webMvcEntityLinks", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebMvcEntityLinksConfiguration.class).webMvcEntityLinks(args.get(0)));
  }

  /**
   * Get the bean definition for 'webMvcEntityLinks'.
   */
  public static BeanDefinition getWebMvcEntityLinksBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ControllerEntityLinksFactoryBean.class);
    beanDefinition.setInstanceSupplier(getWebMvcEntityLinksInstanceSupplier());
    return beanDefinition;
  }
}
