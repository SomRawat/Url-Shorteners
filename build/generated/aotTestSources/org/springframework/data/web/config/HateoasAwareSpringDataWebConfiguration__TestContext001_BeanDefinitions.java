package org.springframework.data.web.config;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.PagedResourcesAssemblerArgumentResolver;
import org.springframework.data.web.SlicedResourcesAssembler;
import org.springframework.data.web.SlicedResourcesAssemblerArgumentResolver;

/**
 * Bean definitions for {@link HateoasAwareSpringDataWebConfiguration}.
 */
public class HateoasAwareSpringDataWebConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'pagedResourcesAssembler'.
   */
  private static BeanInstanceSupplier<PagedResourcesAssembler> getPagedResourcesAssemblerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PagedResourcesAssembler>forFactoryMethod(HateoasAwareSpringDataWebConfiguration.class, "pagedResourcesAssembler")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HateoasAwareSpringDataWebConfiguration.class).pagedResourcesAssembler());
  }

  /**
   * Get the bean definition for 'pagedResourcesAssembler'.
   */
  public static BeanDefinition getPagedResourcesAssemblerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PagedResourcesAssembler.class);
    beanDefinition.setTargetType(ResolvableType.forClass(PagedResourcesAssembler.class));
    beanDefinition.setInstanceSupplier(getPagedResourcesAssemblerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'pagedResourcesAssemblerArgumentResolver'.
   */
  private static BeanInstanceSupplier<PagedResourcesAssemblerArgumentResolver> getPagedResourcesAssemblerArgumentResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PagedResourcesAssemblerArgumentResolver>forFactoryMethod(HateoasAwareSpringDataWebConfiguration.class, "pagedResourcesAssemblerArgumentResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HateoasAwareSpringDataWebConfiguration.class).pagedResourcesAssemblerArgumentResolver());
  }

  /**
   * Get the bean definition for 'pagedResourcesAssemblerArgumentResolver'.
   */
  public static BeanDefinition getPagedResourcesAssemblerArgumentResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PagedResourcesAssemblerArgumentResolver.class);
    beanDefinition.setInstanceSupplier(getPagedResourcesAssemblerArgumentResolverInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'slicedResourcesAssembler'.
   */
  private static BeanInstanceSupplier<SlicedResourcesAssembler> getSlicedResourcesAssemblerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SlicedResourcesAssembler>forFactoryMethod(HateoasAwareSpringDataWebConfiguration.class, "slicedResourcesAssembler")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HateoasAwareSpringDataWebConfiguration.class).slicedResourcesAssembler());
  }

  /**
   * Get the bean definition for 'slicedResourcesAssembler'.
   */
  public static BeanDefinition getSlicedResourcesAssemblerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SlicedResourcesAssembler.class);
    beanDefinition.setTargetType(ResolvableType.forClass(SlicedResourcesAssembler.class));
    beanDefinition.setInstanceSupplier(getSlicedResourcesAssemblerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'slicedResourcesAssemblerArgumentResolver'.
   */
  private static BeanInstanceSupplier<SlicedResourcesAssemblerArgumentResolver> getSlicedResourcesAssemblerArgumentResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SlicedResourcesAssemblerArgumentResolver>forFactoryMethod(HateoasAwareSpringDataWebConfiguration.class, "slicedResourcesAssemblerArgumentResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HateoasAwareSpringDataWebConfiguration.class).slicedResourcesAssemblerArgumentResolver());
  }

  /**
   * Get the bean definition for 'slicedResourcesAssemblerArgumentResolver'.
   */
  public static BeanDefinition getSlicedResourcesAssemblerArgumentResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SlicedResourcesAssemblerArgumentResolver.class);
    beanDefinition.setInstanceSupplier(getSlicedResourcesAssemblerArgumentResolverInstanceSupplier());
    return beanDefinition;
  }
}
