package org.myspring.beans.factory.config;

import org.myspring.beans.BeansException;
import org.myspring.beans.factory.BeanFactory;

/**
 * Extension of the {@link BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * Constant that indicates no externally defined autowiring. Note that
     * BeanFactoryAware etc and annotation-driven injection will still be applied.
     */
    int AUTOWIRE_NO = 0;

    /**
     * Constant that indicates autowiring bean properties by name
     * (applying to all bean property setters).
     */
    int AUTOWIRE_BY_NAME = 1;

    /**
     * Constant that indicates autowiring bean properties by type
     * (applying to all bean property setters).
     */
    int AUTOWIRE_BY_TYPE = 2;

    /**
     * Constant that indicates autowiring the greediest constructor that
     * can be satisfied (involves resolving the appropriate constructor).
     */
    int AUTOWIRE_CONSTRUCTOR = 3;

    /**
     * Fully create a new bean instance of the given class.
     * @return the new bean instance
     * @throws BeansException if instantiation or wiring failed
     */
    <T> T createBean(Class<T> beanClass) throws BeansException;

    /**
     * Populate the given bean instance through applying after-instantiation callbacks
     * and bean property post-processing (e.g. for annotation-driven injection).
     * <p>Note: This is essentially intended for (re-)populating annotated fields and
     * methods, either for new instances or for deserialized instances. It does
     * <i>not</i> imply traditional by-name or by-type autowiring of properties;
     * use {@link #autowireBeanProperties} for those purposes.
     * @param existingBean the existing bean instance
     * @throws BeansException if wiring failed
     */
    void autowireBean(Object existingBean) throws BeansException;

    /**
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object configureBean(Object existingBean, String beanName) throws BeansException;

    // TODO: 18-Jul-18  finished here
}
