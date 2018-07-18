package org.myspring.beans.factory;

import org.myspring.beans.BeansException;
import org.springframework.core.ResolvableType;

import javax.annotation.Nullable;

/**
 * The root interface for accessing a Spring bean container.
 */
public interface BeanFactory {

    /**
     * Used to dereference a {@link FactoryBean} instance and distinguish it from
     * beans <i>created</i> by the FactoryBean. For example, if the bean named
     * {@code myJndiObject} is a FactoryBean, getting {@code &myJndiObject}
     * will return the factory, not the instance returned by the factory.
     */
    String FACTORY_BEAN_PREFIX = "&";

    /**
     * Return an instance, which may be shared or independent, of the specific bean.
     *
     * @param name the name of the bean to retrieve
     * @return an instance of the bean
     * @throws NoSuchBeanDefinitionException if the is no bean definition
     *                                       with the specified name
     * @throws BeansException                if the bean could not obtained
     */
    Object getBean(String name) throws BeansException;

    /**
     * Return an instance, which may be shared or independent, of the specific bean.
     * <p>Behaves the same as {@link #getBean(String)}, but provides a measure of type
     * safety by throwing a BeanNotOfRequiredTypeException if the bean is not of the
     * required type.
     *
     * @param name         the name of the bean to retrieve
     * @param requiredType type the bean must match. Can be an interface or superclass of
     *                     the actual class or {@code null} for any match
     * @return the instance of the bean
     * @throws NoSuchBeanDefinitionException  if the is no bean definition
     *                                        with the specified name
     * @throws BeanNotOfRequiredTypeException if the bean is not of required type
     * @throws BeansException                 if the bean could not obtained
     */
    <T> T getBean(String name, @Nullable Class<T> requiredType) throws BeansException;

    /**
     * Return an instance, which may be shared or independent, of the specific bean.
     *
     * @param name the name of the bean to retrieve
     * @param args arguments to use when creating a bean instance using explicit arguments
     * @return an instance of the bean
     * @throws NoSuchBeanDefinitionException if the is no bean definition
     *                                       with the specified name
     * @throws BeanDefinitionStoreException  if arguments have been given but
     *                                       the affected bean is not a prototype
     * @throws BeansException                if the bean could not obtained
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * Return an instance that uniquely matches the given object type, if any.
     *
     * @param requiredType type the bean must match. Can be an interface or superclass of
     *                     the actual class
     * @return an instance of the single bean matching the required type
     * @throws NoSuchBeanDefinitionException   if no bean of the given type was found
     * @throws NoUniqueBeanDefinitionException if more than one bean of the given type was found
     * @throws BeansException                  if the bean could not obtained
     */
    <T> T getBean(Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType, Object... args) throws BeansException;

    boolean containsBean(String name);

    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

    boolean isPrototype(String name) throws NoSuchBeanDefinitionException;

    boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;

    boolean isTypeMatch(String name, @Nullable Class<?> typeToMatch) throws NoSuchBeanDefinitionException;

    @Nullable
    Class<?> getType(String name) throws NoSuchBeanDefinitionException;

    String[] getAliases(String name);
}
