package com.abinator.urlshortener;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link UrlshortenerApplication}.
 */
public class UrlshortenerApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'urlshortenerApplication'.
   */
  public static BeanDefinition getUrlshortenerApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UrlshortenerApplication.class);
    beanDefinition.setTargetType(UrlshortenerApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(UrlshortenerApplication.class);
    beanDefinition.setInstanceSupplier(UrlshortenerApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
