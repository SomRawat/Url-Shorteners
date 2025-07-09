package com.abinator.urlshortener.controller;

import com.abinator.urlshortener.services.manager.UrlManager;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UrlController}.
 */
public class UrlController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'urlController'.
   */
  private static BeanInstanceSupplier<UrlController> getUrlControllerInstanceSupplier() {
    return BeanInstanceSupplier.<UrlController>forConstructor(UrlManager.class)
            .withGenerator((registeredBean, args) -> new UrlController(args.get(0)));
  }

  /**
   * Get the bean definition for 'urlController'.
   */
  public static BeanDefinition getUrlControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UrlController.class);
    beanDefinition.setInstanceSupplier(getUrlControllerInstanceSupplier());
    return beanDefinition;
  }
}
