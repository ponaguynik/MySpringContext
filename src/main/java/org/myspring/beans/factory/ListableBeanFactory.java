package org.myspring.beans.factory;

import org.myspring.beans.BeansException;
import org.springframework.core.ResolvableType;

import javax.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate all their instances, rather than attempting bean lookup
 * by name one by one as requested by clients.
 */
public interface ListableBeanFactory extends BeanFactory {

    boolean containsBeanDefinition(String beanName);

    int getBeanDefinitionCount();

    String[] getBeanDefinitionNames();

    String[] getBeanNamesForType(ResolvableType type);

    String[] getBeanNamesForType(@Nullable Class<?> type);

    String[] getBeanNamesForType(@Nullable Class<?> type, boolean includeNonSingletons, boolean allowEagerInit);

    <T> Map<String, T> getBeansOfType(@Nullable Class<T> type) throws BeansException;

    <T> Map<String, T> getBeansOfType(@Nullable Class<T> type, boolean includeNonSingletons, boolean allowEagerInit)
            throws BeansException;

    /**
     * Find all names of beans whose {@code Class} has the supplied {@link Annotation}
     * type, without creating bean instances yet.
     * @param annotationType the type of annotation to look for
     * @return the names of all matching beans
     */
    String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType);

    Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) throws BeansException;

    /**
     * Find an {@link Annotation} of {@code annotationType} on the specified
     * bean, traversing its interfaces and super classes if no annotation can be
     * found on the given class itself.
     * @param beanName the name of the bean to look for annotations on
     * @param annotationType the annotation class to look for
     * @return the annotation of the given type if found, or {@code null} otherwise
     * @throws NoSuchBeanDefinitionException if there is no bean with the given name
     */
    @Nullable
    <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType)
            throws NoSuchBeanDefinitionException;
}
