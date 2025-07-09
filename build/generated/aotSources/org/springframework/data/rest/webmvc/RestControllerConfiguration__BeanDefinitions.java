package org.springframework.data.rest.webmvc;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.repository.support.RepositoryInvokerFactory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryResourceMappings;
import org.springframework.data.rest.webmvc.alps.AlpsController;
import org.springframework.data.rest.webmvc.json.PersistentEntityToJsonSchemaConverter;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;

/**
 * Bean definitions for {@link RestControllerConfiguration}.
 */
public class RestControllerConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.data.rest.webmvc.RestControllerConfiguration'.
   */
  private static BeanInstanceSupplier<RestControllerConfiguration> getRestControllerConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RestControllerConfiguration>forConstructor(RepositoryRestConfiguration.class, RepositoryResourceMappings.class, Repositories.class, RepositoryEntityLinks.class)
            .withGenerator((registeredBean, args) -> new RestControllerConfiguration(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'restControllerConfiguration'.
   */
  public static BeanDefinition getRestControllerConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestControllerConfiguration.class);
    beanDefinition.setInstanceSupplier(getRestControllerConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'repositoryController'.
   */
  private static BeanInstanceSupplier<RepositoryController> getRepositoryControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RepositoryController>forFactoryMethod(RestControllerConfiguration.class, "repositoryController")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(RestControllerConfiguration.class).repositoryController());
  }

  /**
   * Get the bean definition for 'repositoryController'.
   */
  public static BeanDefinition getRepositoryControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryController.class);
    beanDefinition.setInstanceSupplier(getRepositoryControllerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'repositoryEntityController'.
   */
  private static BeanInstanceSupplier<RepositoryEntityController> getRepositoryEntityControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RepositoryEntityController>forFactoryMethod(RestControllerConfiguration.class, "repositoryEntityController", HttpHeadersPreparer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RestControllerConfiguration.class).repositoryEntityController(args.get(0)));
  }

  /**
   * Get the bean definition for 'repositoryEntityController'.
   */
  public static BeanDefinition getRepositoryEntityControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryEntityController.class);
    beanDefinition.setInstanceSupplier(getRepositoryEntityControllerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'repositoryPropertyReferenceController'.
   */
  private static BeanInstanceSupplier<RepositoryPropertyReferenceController> getRepositoryPropertyReferenceControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RepositoryPropertyReferenceController>forFactoryMethod(RestControllerConfiguration.class, "repositoryPropertyReferenceController", RepositoryInvokerFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RestControllerConfiguration.class).repositoryPropertyReferenceController(args.get(0)));
  }

  /**
   * Get the bean definition for 'repositoryPropertyReferenceController'.
   */
  public static BeanDefinition getRepositoryPropertyReferenceControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositoryPropertyReferenceController.class);
    beanDefinition.setInstanceSupplier(getRepositoryPropertyReferenceControllerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'repositorySearchController'.
   */
  private static BeanInstanceSupplier<RepositorySearchController> getRepositorySearchControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RepositorySearchController>forFactoryMethod(RestControllerConfiguration.class, "repositorySearchController", HttpHeadersPreparer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RestControllerConfiguration.class).repositorySearchController(args.get(0)));
  }

  /**
   * Get the bean definition for 'repositorySearchController'.
   */
  public static BeanDefinition getRepositorySearchControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositorySearchController.class);
    beanDefinition.setInstanceSupplier(getRepositorySearchControllerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'repositorySchemaController'.
   */
  private static BeanInstanceSupplier<RepositorySchemaController> getRepositorySchemaControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RepositorySchemaController>forFactoryMethod(RestControllerConfiguration.class, "repositorySchemaController", PersistentEntityToJsonSchemaConverter.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RestControllerConfiguration.class).repositorySchemaController(args.get(0)));
  }

  /**
   * Get the bean definition for 'repositorySchemaController'.
   */
  public static BeanDefinition getRepositorySchemaControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RepositorySchemaController.class);
    beanDefinition.setInstanceSupplier(getRepositorySchemaControllerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'alpsController'.
   */
  private static BeanInstanceSupplier<AlpsController> getAlpsControllerInstanceSupplier() {
    return BeanInstanceSupplier.<AlpsController>forFactoryMethod(RestControllerConfiguration.class, "alpsController")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(RestControllerConfiguration.class).alpsController());
  }

  /**
   * Get the bean definition for 'alpsController'.
   */
  public static BeanDefinition getAlpsControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AlpsController.class);
    beanDefinition.setInstanceSupplier(getAlpsControllerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'profileController'.
   */
  private static BeanInstanceSupplier<ProfileController> getProfileControllerInstanceSupplier() {
    return BeanInstanceSupplier.<ProfileController>forFactoryMethod(RestControllerConfiguration.class, "profileController")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(RestControllerConfiguration.class).profileController());
  }

  /**
   * Get the bean definition for 'profileController'.
   */
  public static BeanDefinition getProfileControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProfileController.class);
    beanDefinition.setInstanceSupplier(getProfileControllerInstanceSupplier());
    return beanDefinition;
  }
}
